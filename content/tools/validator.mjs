export const REQUIRED_SECTIONS = ["简介", "工作原理", "关键参数", "选型要点", "典型用法", "注意事项", "常见故障与误区"];
const ALLOWED_KINDS = new Set(["category", "model"]);
const ALLOWED_LICENSES = new Set(["CC-BY-4.0", "CC0-1.0", "Apache-2.0", "MIT", "Public-Domain"]);
const list = (value = "") => value.split("|").map(item => item.trim()).filter(Boolean);

function front(markdown) {
  if (!markdown.startsWith("---\n")) throw Error("missing front matter");
  const end = markdown.indexOf("\n---\n", 4);
  if (end < 0) throw Error("unterminated front matter");
  const meta = {};
  for (const line of markdown.slice(4, end).split("\n")) {
    if (!line.trim()) continue;
    const index = line.indexOf(":");
    if (index < 1) throw Error("invalid front matter line: " + line);
    meta[line.slice(0, index).trim()] = line.slice(index + 1).trim();
  }
  return { meta, body: markdown.slice(end + 5) };
}

export function parseEntry(sourcePath, markdown) {
  const { meta, body } = front(markdown.replaceAll("\r\n", "\n"));
  const headings = [...body.matchAll(/^##\s+(.+)$/gm)];
  const sections = headings.map((match, index) => ({
    title: match[1].trim(),
    body: body.slice(match.index + match[0].length, headings[index + 1]?.index ?? body.length).trim()
  }));
  return {
    id: meta.id ?? "",
    kind: meta.kind ?? "",
    title: meta.title ?? "",
    englishName: meta.englishName ?? "",
    aliases: list(meta.aliases),
    categoryId: meta.categoryId ?? "",
    summary: meta.summary ?? "",
    keywords: list(meta.keywords),
    sections,
    images: [{
      assetPath: meta.image ?? "",
      altText: meta.imageAlt ?? "",
      attribution: meta.imageAttribution ?? "",
      license: meta.imageLicense ?? ""
    }],
    relatedIds: list(meta.relatedIds),
    sources: [{
      title: meta.sourceTitle ?? "",
      publisher: meta.sourcePublisher ?? "",
      url: meta.sourceUrl ?? "",
      accessedAt: meta.sourceAccessedAt ?? ""
    }],
    sourcePath
  };
}

export function validateManifest(manifest, expectedCount) {
  const errors = [];
  if (manifest?.schemaVersion !== 1) errors.push("manifest: unsupported schemaVersion");
  const contentVersion = manifest?.contentVersion;
  if (!(Number.isInteger(contentVersion) && contentVersion > 0) &&
      !(typeof contentVersion === "string" && /^(?:0|[1-9]\d*)(?:\.\d+){0,2}$/.test(contentVersion))) {
    errors.push("manifest: invalid contentVersion");
  }
  if (!/^\d{4}-\d{2}-\d{2}T\d{2}:\d{2}:\d{2}Z$/.test(manifest?.generatedAt ?? "")) {
    errors.push("manifest: invalid generatedAt");
  }
  if (!Number.isInteger(manifest?.entryCount) || manifest.entryCount !== expectedCount) {
    errors.push("manifest: entryCount does not match catalog");
  }
  if (!/^[a-f0-9]{64}$/i.test(manifest?.sha256 ?? "")) errors.push("manifest: invalid sha256");
  return errors;
}

export function validateCategories(categories) {
  const errors = [];
  if (!Array.isArray(categories) || categories.length === 0) return ["categories: empty"];
  const ids = new Set();
  for (const category of categories) {
    if (!category.id) errors.push("category: missing id");
    else if (ids.has(category.id)) errors.push("duplicate category id: " + category.id);
    else ids.add(category.id);
    if (!category.title) errors.push((category.id || "category") + ": missing title");
    if (!Number.isInteger(category.sortOrder)) errors.push((category.id || "category") + ": invalid sortOrder");
  }
  for (const category of categories) {
    if (category.parentId != null && !ids.has(category.parentId)) {
      errors.push(category.id + ": unknown parent: " + category.parentId);
    }
    if (category.parentId === category.id) errors.push(category.id + ": category cannot parent itself");
  }
  return errors;
}

export function validateCatalog(entries, categories, assets, minimumCount = 0) {
  const errors = [...validateCategories(categories)];
  const ids = new Set();
  const categoryIds = new Set(categories.map(category => category.id));
  if (entries.length < minimumCount) errors.push(`entry count ${entries.length} is below minimum ${minimumCount}`);

  for (const entry of entries) {
    if (!entry.id) errors.push(`${entry.sourcePath}: missing id`);
    else if (ids.has(entry.id)) errors.push(`duplicate id: ${entry.id}`);
    else ids.add(entry.id);
    if (!ALLOWED_KINDS.has(entry.kind)) errors.push(`${entry.id || entry.sourcePath}: invalid kind: ${entry.kind}`);
    for (const field of ["title", "englishName", "categoryId", "summary"]) {
      if (!entry[field]) errors.push(`${entry.id || entry.sourcePath}: missing ${field}`);
    }
    if (!entry.aliases.length) errors.push(`${entry.id}: missing aliases`);
    if (!entry.keywords.length) errors.push(`${entry.id}: missing keywords`);
    if (!categoryIds.has(entry.categoryId)) errors.push(`${entry.id}: unknown category: ${entry.categoryId}`);
    for (const section of REQUIRED_SECTIONS) {
      if (!entry.sections.find(item => item.title === section)?.body) errors.push(`${entry.id}: missing section: ${section}`);
    }
    if (!entry.relatedIds.length) errors.push(`${entry.id}: missing relatedIds`);
    for (const image of entry.images) {
      if (!image.assetPath || !assets.has(image.assetPath)) errors.push(`${entry.id}: missing image: ${image.assetPath}`);
      if (!image.altText || !image.attribution || !image.license) errors.push(`${entry.id}: incomplete image metadata`);
      if (image.license && !ALLOWED_LICENSES.has(image.license)) errors.push(`${entry.id}: unsupported image license: ${image.license}`);
    }
    for (const source of entry.sources) {
      if (!source.title || !source.publisher || !/^https:\/\//.test(source.url) ||
          !/^\d{4}-\d{2}-\d{2}$/.test(source.accessedAt)) {
        errors.push(`${entry.id}: invalid source reference`);
      }
    }
  }
  for (const entry of entries) {
    for (const id of entry.relatedIds) {
      if (!ids.has(id)) errors.push(`${entry.id}: unknown related id: ${id}`);
      if (id === entry.id) errors.push(`${entry.id}: cannot relate to itself`);
    }
  }
  return errors;
}

const norm = value => String(value ?? "").normalize("NFKC").toLocaleLowerCase();
export function rankEntries(entries, query) {
  const normalizedQuery = norm(query).trim();
  if (!normalizedQuery) return entries;
  return entries.map((entry, position) => {
    const title = norm(entry.title);
    const englishName = norm(entry.englishName);
    const aliases = entry.aliases.map(norm);
    const score = title === normalizedQuery || englishName === normalizedQuery ? 400
      : aliases.includes(normalizedQuery) ? 300
      : title.startsWith(normalizedQuery) || englishName.startsWith(normalizedQuery) ? 200
      : [title, englishName, ...aliases, ...entry.keywords.map(norm), norm(entry.summary)]
          .some(value => value.includes(normalizedQuery)) ? 100 : 0;
    return { entry, position, score };
  }).filter(item => item.score)
    .sort((left, right) => right.score - left.score || left.position - right.position)
    .map(item => item.entry);
}
