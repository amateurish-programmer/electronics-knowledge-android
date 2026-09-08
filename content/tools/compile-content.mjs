import { createHash } from "node:crypto";
import { mkdir, readFile, writeFile, cp } from "node:fs/promises";
import path from "node:path";
import { loadCatalog } from "./validate-content.mjs";
import { validateCatalog, validateManifest } from "./validator.mjs";

const root = process.cwd();
const catalog = await loadCatalog(root);
const manifest = JSON.parse(await readFile(path.join(root, "content", "manifest.json"), "utf8"));
const errors = [
  ...validateManifest(manifest, catalog.entries.length),
  ...validateCatalog(catalog.entries, catalog.categories, catalog.assets, 100)
];
if (errors.length) throw Error(errors.join("\n"));

const entries = catalog.entries.map(({ sourcePath, ...entry }) => entry);
const payload = { categories: catalog.categories, entries };
const sha256 = createHash("sha256").update(JSON.stringify(payload)).digest("hex");
const bundle = { manifest: { ...manifest, entryCount: entries.length, sha256 }, ...payload };
const output = path.join(root, "app", "src", "main", "assets");
await mkdir(path.join(output, "content", "images"), { recursive: true });
await writeFile(path.join(output, "content-bundle.json"), JSON.stringify(bundle, null, 2) + "\n");
await cp(path.join(root, "content", "assets", "images"), path.join(output, "content", "images"), { recursive: true });
console.log(`Compiled ${entries.length} entries (${sha256}).`);
