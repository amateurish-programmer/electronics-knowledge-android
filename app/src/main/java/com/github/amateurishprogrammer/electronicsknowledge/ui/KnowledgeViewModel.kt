package com.github.amateurishprogrammer.electronicsknowledge.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.github.amateurishprogrammer.electronicsknowledge.data.*
import com.github.amateurishprogrammer.electronicsknowledge.domain.NavigationPolicy
import com.github.amateurishprogrammer.electronicsknowledge.domain.SearchCandidate
import com.github.amateurishprogrammer.electronicsknowledge.domain.SearchRanker
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

enum class Destination { HOME, CATEGORIES, FAVORITES, RECENT }

data class AppUiState(
    val loading: Boolean = true,
    val error: String? = null,
    val categories: List<CategoryEntity> = emptyList(),
    val entries: List<KnowledgeEntry> = emptyList(),
    val states: Map<String, EntryStateEntity> = emptyMap(),
    val query: String = "",
    val destination: Destination = Destination.HOME,
    val selectedCategory: String? = null,
    val selected: KnowledgeEntry? = null,
    val dark: Boolean? = null
)

private data class Catalog(
    val categories: List<CategoryEntity>,
    val entries: List<KnowledgeEntry>,
    val states: Map<String, EntryStateEntity>
)
private data class Controls(
    val query: String,
    val destination: Destination,
    val category: String?,
    val selected: KnowledgeEntry?
)

class KnowledgeViewModel(app: Application) : AndroidViewModel(app) {
    private val repo = KnowledgeRepository(app, AppDatabase.get(app))
    private val theme = ThemeStore(app)
    private val query = MutableStateFlow("")
    private val destination = MutableStateFlow(Destination.HOME)
    private val category = MutableStateFlow<String?>(null)
    private val selected = MutableStateFlow<KnowledgeEntry?>(null)
    private val error = MutableStateFlow<String?>(null)

    private val catalog = combine(repo.categories(), repo.entries(), repo.states()) { categories, entries, states ->
        Catalog(categories, entries.map(repo::decode), states.associateBy { it.entryId })
    }
    private val controls = combine(query, destination, category, selected) { q, d, c, s ->
        Controls(q, d, c, s)
    }

    val state = combine(catalog, controls, theme.dark, error) { catalog, controls, dark, failure ->
        AppUiState(
            loading = false,
            error = failure,
            categories = catalog.categories,
            entries = catalog.entries,
            states = catalog.states,
            query = controls.query,
            destination = controls.destination,
            selectedCategory = controls.category,
            selected = controls.selected,
            dark = dark
        )
    }.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5_000), AppUiState())

    init {
        viewModelScope.launch {
            runCatching { repo.ensureContent() }
                .onFailure { error.value = it.message ?: "内容导入失败" }
        }
    }

    fun search(value: String) {
        query.value = value
        destination.value = Destination.HOME
        selected.value = null
    }

    fun navigate(value: Destination) {
        destination.value = value
        if (value != Destination.HOME) query.value = ""
        selected.value = null
        category.value = null
    }

    fun selectCategory(id: String) {
        category.value = id
        destination.value = Destination.CATEGORIES
    }

    fun open(entry: KnowledgeEntry) {
        selected.value = entry
        viewModelScope.launch { repo.viewed(entry.id) }
    }

    fun back() {
        if (selected.value != null) selected.value = null else category.value = null
    }

    fun favorite(id: String) = viewModelScope.launch { repo.toggle(id) }
    fun dark(value: Boolean) = viewModelScope.launch { theme.set(value) }

    fun related(entry: KnowledgeEntry, entries: List<KnowledgeEntry>): List<KnowledgeEntry> {
        val byId = entries.associateBy { it.id }
        return entry.relatedIds.mapNotNull(byId::get)
    }

    fun visible(state: AppUiState): List<KnowledgeEntry> {
        val base = when (state.destination) {
            Destination.FAVORITES -> state.entries.filter { state.states[it.id]?.favorite == true }
            Destination.RECENT -> state.entries.filter { state.states[it.id]?.lastViewedAt != null }
                .sortedByDescending { state.states[it.id]?.lastViewedAt }
            Destination.CATEGORIES -> state.selectedCategory
                ?.let { id -> state.entries.filter { it.categoryId == id } }
                ?: emptyList()
            Destination.HOME -> state.entries
        }
        val visibleQuery = NavigationPolicy.effectiveQuery(state.destination.name, state.query)
        if (visibleQuery.isBlank()) return base
        val byId = base.associateBy { it.id }
        return SearchRanker.rank(
            base.map { SearchCandidate(it.id, it.title, it.englishName, it.aliases, it.keywords, it.summary) },
            visibleQuery
        ).mapNotNull { byId[it.id] }
    }
}
