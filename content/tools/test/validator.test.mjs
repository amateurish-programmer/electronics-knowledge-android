import test from "node:test";
import assert from "node:assert/strict";
import { parseEntry, validateCatalog, rankEntries } from "../validator.mjs";

const validMarkdown = `---
id: resistor
kind: category
title: 电阻器
englishName: Resistor
aliases: 电阻|固定电阻
categoryId: passive
summary: 用于限流、分压和偏置的基础无源器件。
keywords: 限流|分压|欧姆定律
image: images/passive.svg
imageAlt: 电阻器电路符号
imageAttribution: 本项目自绘
imageLicense: CC-BY-4.0
relatedIds: capacitor
sourceTitle: IEC 60062 overview
sourcePublisher: IEC
sourceUrl: https://www.iec.ch/
sourceAccessedAt: 2026-09-07
---
## 简介
电阻器限制电流并建立电压。
## 工作原理
服从欧姆定律。
## 关键参数
阻值、精度和额定功率。
## 选型要点
校核功耗和工作电压。
## 典型用法
限流、分压、偏置。
## 注意事项
留出功率降额。
## 常见故障与误区
实测阻值会受并联支路影响。
`;

test("parseEntry returns the fixed public content fields", () => {
  const entry = parseEntry("resistor.md", validMarkdown);
  assert.equal(entry.id, "resistor");
  assert.equal(entry.title, "电阻器");
  assert.deepEqual(entry.aliases, ["电阻", "固定电阻"]);
  assert.equal(entry.sections.length, 7);
  assert.equal(entry.images[0].license, "CC-BY-4.0");
  assert.equal(entry.sources[0].publisher, "IEC");
});

test("validateCatalog rejects duplicate ids and broken relations", () => {
  const resistor = parseEntry("resistor.md", validMarkdown);
  const duplicate = { ...resistor, sourcePath: "duplicate.md", relatedIds: ["missing"] };
  const errors = validateCatalog([resistor, duplicate], [{ id: "passive", title: "无源器件", sortOrder: 1 }], new Set(["images/passive.svg"]));
  assert.ok(errors.some((error) => error.includes("duplicate id: resistor")));
  assert.ok(errors.some((error) => error.includes("unknown related id: missing")));
});

test("rankEntries prioritizes exact title then alias then prefix then body", () => {
  const entries = [
    { id: "body", title: "偏置知识", englishName: "", aliases: [], keywords: [], summary: "电阻用于分压" },
    { id: "prefix", title: "电阻网络", englishName: "", aliases: [], keywords: [], summary: "" },
    { id: "alias", title: "固定阻性器件", englishName: "", aliases: ["电阻"], keywords: [], summary: "" },
    { id: "exact", title: "电阻", englishName: "Resistor", aliases: [], keywords: [], summary: "" }
  ];
  assert.deepEqual(rankEntries(entries, "电阻").map((entry) => entry.id), ["exact", "alias", "prefix", "body"]);
});
