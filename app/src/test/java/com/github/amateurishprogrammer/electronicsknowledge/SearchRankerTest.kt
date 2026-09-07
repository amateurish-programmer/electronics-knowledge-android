package com.github.amateurishprogrammer.electronicsknowledge

import com.github.amateurishprogrammer.electronicsknowledge.domain.SearchCandidate
import com.github.amateurishprogrammer.electronicsknowledge.domain.SearchRanker
import org.junit.Assert.assertEquals
import org.junit.Test

class SearchRankerTest {
    @Test fun exactTitleThenAliasThenPrefixThenBody() {
        val entries = listOf(
            SearchCandidate("body", "偏置知识", "", emptyList(), listOf("分压"), "电阻用于分压"),
            SearchCandidate("prefix", "电阻网络", "", emptyList(), emptyList(), ""),
            SearchCandidate("alias", "固定阻性器件", "", listOf("电阻"), emptyList(), ""),
            SearchCandidate("exact", "电阻", "Resistor", emptyList(), emptyList(), "")
        )
        assertEquals(listOf("exact", "alias", "prefix", "body"), SearchRanker.rank(entries, "电阻").map { it.id })
    }

    @Test fun modelSearchIsCaseInsensitiveAndSupportsPartialText() {
        val entries = listOf(SearchCandidate("lm358", "LM358双运放", "LM358 Dual Op Amp", listOf("运放"), emptyList(), ""))
        assertEquals("lm358", SearchRanker.rank(entries, "lm35").single().id)
    }

    @Test fun blankQueryPreservesCatalogOrder() {
        val entries = listOf(SearchCandidate("a", "A", "", emptyList(), emptyList(), ""), SearchCandidate("b", "B", "", emptyList(), emptyList(), ""))
        assertEquals(listOf("a", "b"), SearchRanker.rank(entries, "  ").map { it.id })
    }
}
