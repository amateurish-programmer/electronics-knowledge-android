import test from "node:test";
import assert from "node:assert/strict";
import { loadCatalog } from "../validate-content.mjs";

test("representative component sources match their subject", async () => {
  const catalog = await loadCatalog(process.cwd());
  const entries = new Map(catalog.entries.map(entry => [entry.id, entry]));
  const expected = {
    adc: ["Texas Instruments", "ti.com/product-category/data-converters/"],
    dac: ["Texas Instruments", "ti.com/product-category/data-converters/"],
    comparator: ["Texas Instruments", "ti.com/product-category/amplifiers/comparators/"],
    "current-sense-amplifier": ["Texas Instruments", "ti.com/product-category/amplifiers/current-sense/"],
    "op-amp": ["Texas Instruments", "ti.com/product-category/amplifiers/"],
    buzzer: ["Same Sky", "sameskydevices.com/"],
    speaker: ["Same Sky", "sameskydevices.com/"],
    lcd1602: ["Newhaven Display", "newhavendisplay.com/"],
    "oled-module": ["Solomon Systech", "solomon-systech.com/"],
    sram: ["Infineon", "infineon.com/products/memories/sram-static-ram"]
  };
  for (const [id, [publisher, urlPart]] of Object.entries(expected)) {
    const source = entries.get(id)?.sources?.[0];
    assert.equal(source?.publisher, publisher, id + " publisher");
    assert.ok(source?.url.includes(urlPart), id + " URL: " + source?.url);
    assert.ok(!source?.title.includes("官方"), id + " source title must not overclaim");
  }
});
