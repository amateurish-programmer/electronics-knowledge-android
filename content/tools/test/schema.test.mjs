import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";
import { validateCatalog, validateCategories, validateManifest } from "../validator.mjs";

const categories = [
  { id: "passive", parentId: null, title: "无源器件", sortOrder: 1 },
  { id: "resistors", parentId: "passive", title: "电阻", sortOrder: 2 }
];
const entry = {
  id: "resistor", kind: "category", title: "电阻器", englishName: "Resistor", aliases: ["电阻"],
  categoryId: "resistors", summary: "限制电流并建立分压或偏置。", keywords: ["限流"],
  sections: [
    { title: "简介", body: "基础无源器件。" }, { title: "工作原理", body: "利用材料电阻特性耗散电能。" },
    { title: "关键参数", body: "阻值、精度、功率和温漂。" }, { title: "选型要点", body: "校核工作电压和功耗降额。" },
    { title: "典型用法", body: "限流、分压、偏置和终端。" }, { title: "注意事项", body: "脉冲功率需要单独校核。" },
    { title: "常见故障与误区", body: "不要忽略封装功率与温升。" }
  ],
  images: [{ assetPath: "images/passive.svg", altText: "电阻符号", attribution: "项目自绘", license: "CC-BY-4.0" }],
  relatedIds: ["capacitor"],
  sources: [{ title: "Resistors", publisher: "Vishay", url: "https://www.vishay.com/en/resistors/", accessedAt: "2026-09-07" }],
  sourcePath: "resistor.md"
};
const capacitor = { ...entry, id: "capacitor", title: "电容器", relatedIds: ["resistor"], sourcePath: "capacitor.md" };
const assets = new Set(["images/passive.svg"]);

test("manifest matches the Android model and rejects placeholder hashes", () => {
  assert.deepEqual(validateManifest({ schemaVersion: 1, contentVersion: "1.0.1", generatedAt: "2026-09-08T00:00:00Z", entryCount: 2, sha256: "a".repeat(64) }, 2), []);
  assert.ok(validateManifest({ schemaVersion: 1, contentVersion: 2, generatedAt: "2026-09-08T00:00:00Z", entryCount: 2, sha256: "a".repeat(64) }, 2).some(x => x.includes("contentVersion")));
  assert.ok(validateManifest({ schemaVersion: 1, contentVersion: "1.0.1", generatedAt: "2026-09-08T00:00:00Z", entryCount: 2, sha256: "0".repeat(64) }, 2).some(x => x.includes("sha256")));
});
test("catalog manifest is bumped for the curated content revision", async () => {
  const manifest = JSON.parse(await readFile("content/manifest.json", "utf8"));
  assert.equal(manifest.contentVersion, "1.0.1");
});
test("categories require unique ids and valid parents", () => {
  assert.deepEqual(validateCategories(categories), []);
  const errors = validateCategories([...categories, { id: "passive", parentId: "missing", title: "", sortOrder: "x" }]);
  assert.ok(errors.some(x => x.includes("duplicate category id")));
  assert.ok(errors.some(x => x.includes("unknown parent")));
});
test("entries require allowed kind, relations, and licensed images", () => {
  assert.deepEqual(validateCatalog([entry, capacitor], categories, assets), []);
  const invalid = { ...entry, kind: "draft", relatedIds: [], images: [{ ...entry.images[0], license: "unknown" }] };
  const errors = validateCatalog([invalid, capacitor], categories, assets);
  assert.ok(errors.some(x => x.includes("invalid kind")));
  assert.ok(errors.some(x => x.includes("missing relatedIds")));
  assert.ok(errors.some(x => x.includes("unsupported image license")));
});
