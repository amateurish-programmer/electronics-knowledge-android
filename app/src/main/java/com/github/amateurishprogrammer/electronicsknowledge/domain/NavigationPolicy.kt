package com.github.amateurishprogrammer.electronicsknowledge.domain

enum class BackTarget { DETAIL, CATEGORY, SYSTEM }

object NavigationPolicy {
    fun effectiveQuery(destination: String, query: String): String =
        if (destination == "HOME") query else ""

    fun backTarget(hasDetail: Boolean, hasCategory: Boolean): BackTarget = when {
        hasDetail -> BackTarget.DETAIL
        hasCategory -> BackTarget.CATEGORY
        else -> BackTarget.SYSTEM
    }
}
