import test from "node:test";
import assert from "node:assert/strict";
import { readFile } from "node:fs/promises";

test("direct content compilation validates the manifest before writing assets", async () => {
  const source = await readFile("content/tools/compile-content.mjs", "utf8");
  assert.match(source, /validateManifest\s*\(/);
});
