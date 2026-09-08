package com.github.amateurishprogrammer.electronicsknowledge

import com.github.amateurishprogrammer.electronicsknowledge.domain.BackTarget
import com.github.amateurishprogrammer.electronicsknowledge.domain.NavigationPolicy
import org.junit.Assert.assertEquals
import org.junit.Test

class NavigationPolicyTest {
    @Test
    fun hiddenSearchOnlyFiltersHome() {
        assertEquals("MAX485", NavigationPolicy.effectiveQuery("HOME", "MAX485"))
        assertEquals("", NavigationPolicy.effectiveQuery("FAVORITES", "MAX485"))
        assertEquals("", NavigationPolicy.effectiveQuery("RECENT", "MAX485"))
        assertEquals("", NavigationPolicy.effectiveQuery("CATEGORIES", "MAX485"))
    }

    @Test
    fun backClosesDetailThenCategoryBeforeLeavingApp() {
        assertEquals(BackTarget.DETAIL, NavigationPolicy.backTarget(hasDetail = true, hasCategory = true))
        assertEquals(BackTarget.CATEGORY, NavigationPolicy.backTarget(hasDetail = false, hasCategory = true))
        assertEquals(BackTarget.SYSTEM, NavigationPolicy.backTarget(hasDetail = false, hasCategory = false))
    }
}
