import { readdir, readFile, writeFile } from "node:fs/promises";
import path from "node:path";

const root = process.cwd();
const profileDir = path.join(root, "content", "profiles");
const entryDir = path.join(root, "content", "entries");

function parseMeta(markdown) {
  if (!markdown.startsWith("---\n")) throw new Error("missing front matter");
  const end = markdown.indexOf("\n---\n", 4);
  if (end < 0) throw new Error("unterminated front matter");
  const meta = {};
  for (const line of markdown.slice(4, end).split("\n")) {
    const index = line.indexOf(":");
    if (index > 0) meta[line.slice(0, index).trim()] = line.slice(index + 1).trim();
  }
  return meta;
}

const profileFiles = (await readdir(profileDir)).filter(name => name.endsWith(".json")).sort();
const profiles = {};
for (const name of profileFiles) {
  const group = JSON.parse(await readFile(path.join(profileDir, name), "utf8"));
  for (const [id, profile] of Object.entries(group)) {
    if (profiles[id]) throw new Error("duplicate profile: " + id);
    profiles[id] = profile;
  }
}

const entryFiles = (await readdir(entryDir)).filter(name => name.endsWith(".md")).sort();
const entryIds = entryFiles.map(name => name.slice(0, -3));
const missing = entryIds.filter(id => !profiles[id]);
const extra = Object.keys(profiles).filter(id => !entryIds.includes(id));
if (missing.length || extra.length) {
  throw new Error(`profile mismatch; missing=[${missing.join(",")}], extra=[${extra.join(",")}]`);
}

for (const name of entryFiles) {
  const id = name.slice(0, -3);
  const profile = profiles[id];
  const filePath = path.join(entryDir, name);
  const meta = parseMeta(await readFile(filePath, "utf8"));
  const publisher = profile.publisher ?? meta.sourcePublisher;
  const url = (profile.url ?? meta.sourceUrl).replace(/^http:/, "https:");
  const keywords = [...new Set(profile.usage.split(/[，。、；]/).map(value => value.trim()).filter(Boolean))].join("|");
  const markdown = `---
id: ${meta.id}
kind: ${meta.kind}
title: ${meta.title}
englishName: ${meta.englishName}
aliases: ${meta.aliases}
categoryId: ${meta.categoryId}
summary: ${profile.summary}
keywords: ${keywords}
image: ${meta.image}
imageAlt: ${meta.imageAlt}
imageAttribution: ${meta.imageAttribution}
imageLicense: ${meta.imageLicense}
relatedIds: ${profile.related.join("|")}
sourceTitle: ${meta.title}官方技术资料
sourcePublisher: ${publisher}
sourceUrl: ${url}
sourceAccessedAt: ${meta.sourceAccessedAt}
---
## 简介
${profile.summary}

## 工作原理
${profile.principle}

## 关键参数
${profile.params}

## 选型要点
选型时结合${profile.selection}，并以具体型号、封装和温度条件下的官方数据手册为准。

## 典型用法
${profile.usage}

## 注意事项
${profile.caution}

## 常见故障与误区
${profile.faults}
`;
  await writeFile(filePath, markdown, "utf8");
}
console.log(`Applied ${Object.keys(profiles).length} curated profiles to ${entryFiles.length} Markdown entries.`);
