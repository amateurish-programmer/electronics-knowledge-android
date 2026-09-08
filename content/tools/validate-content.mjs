import { readdir, readFile } from "node:fs/promises";
import path from "node:path";
import { parseEntry, validateCatalog, validateManifest } from "./validator.mjs";

export async function loadCatalog(root = process.cwd()) {
  const entriesPath = path.join(root, "content", "entries");
  const assetsPath = path.join(root, "content", "assets", "images");
  const names = (await readdir(entriesPath)).filter(name => name.endsWith(".md")).sort();
  const entries = await Promise.all(names.map(async name =>
    parseEntry(name, await readFile(path.join(entriesPath, name), "utf8"))
  ));
  const categories = JSON.parse(await readFile(path.join(root, "content", "categories.json"), "utf8"));
  const manifest = JSON.parse(await readFile(path.join(root, "content", "manifest.json"), "utf8"));
  const assets = new Set((await readdir(assetsPath)).map(name => `images/${name}`));
  return { entries, categories, manifest, assets };
}

if (import.meta.url === `file://${process.argv[1]}`) {
  const catalog = await loadCatalog();
  const errors = [
    ...validateCatalog(catalog.entries, catalog.categories, catalog.assets, 100),
    ...validateManifest(catalog.manifest, catalog.entries.length)
  ];
  if (errors.length) {
    console.error(errors.join("\n"));
    process.exitCode = 1;
  } else {
    console.log(`Validated ${catalog.entries.length} entries in ${catalog.categories.length} categories.`);
  }
}
