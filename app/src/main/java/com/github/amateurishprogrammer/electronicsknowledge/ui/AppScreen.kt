package com.github.amateurishprogrammer.electronicsknowledge.ui

import androidx.activity.compose.BackHandler
import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil3.compose.AsyncImage
import com.github.amateurishprogrammer.electronicsknowledge.data.*
import com.github.amateurishprogrammer.electronicsknowledge.domain.BackTarget
import com.github.amateurishprogrammer.electronicsknowledge.domain.NavigationPolicy

@Composable
fun KnowledgeApp(vm: KnowledgeViewModel = viewModel()) {
    val state by vm.state.collectAsState()
    val backTarget = NavigationPolicy.backTarget(
        hasDetail = state.selected != null,
        hasCategory = state.selectedCategory != null
    )
    BackHandler(enabled = backTarget != BackTarget.SYSTEM, onBack = vm::back)

    KnowledgeTheme(state.dark ?: false) {
        Scaffold(
            bottomBar = {
                if (state.selected == null) {
                    NavigationBar {
                        listOf(
                            Destination.HOME to Icons.Default.Home,
                            Destination.CATEGORIES to Icons.Default.List,
                            Destination.FAVORITES to Icons.Default.Favorite,
                            Destination.RECENT to Icons.Default.History
                        ).forEach { (destination, icon) ->
                            NavigationBarItem(
                                selected = state.destination == destination,
                                onClick = { vm.navigate(destination) },
                                icon = { Icon(icon, null) },
                                label = {
                                    Text(
                                        when (destination) {
                                            Destination.HOME -> "首页"
                                            Destination.CATEGORIES -> "分类"
                                            Destination.FAVORITES -> "收藏"
                                            Destination.RECENT -> "最近"
                                        }
                                    )
                                }
                            )
                        }
                    }
                }
            }
        ) { padding ->
            AnimatedContent(
                targetState = state.selected,
                modifier = Modifier.padding(padding),
                label = "entry"
            ) { entry ->
                if (entry == null) {
                    Catalog(state, vm)
                } else {
                    Detail(
                        entry = entry,
                        favorite = state.states[entry.id]?.favorite == true,
                        related = vm.related(entry, state.entries),
                        back = vm::back,
                        toggle = { vm.favorite(entry.id) },
                        openRelated = vm::open
                    )
                }
            }
        }
    }
}

@Composable
private fun Catalog(state: AppUiState, vm: KnowledgeViewModel) {
    Column(Modifier.fillMaxSize().padding(horizontal = 20.dp)) {
        Row(
            Modifier.fillMaxWidth().padding(top = 22.dp, bottom = 16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(Modifier.weight(1f)) {
                Text("电子专业知识库", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
                Text("元器件手册 · ${state.entries.size} 条", color = MaterialTheme.colorScheme.primary)
            }
            IconButton({ vm.dark(!(state.dark ?: false)) }) {
                Icon(if (state.dark == true) Icons.Default.LightMode else Icons.Default.DarkMode, "切换主题")
            }
        }
        if (state.destination == Destination.HOME) {
            OutlinedTextField(
                value = state.query,
                onValueChange = vm::search,
                modifier = Modifier.fillMaxWidth(),
                leadingIcon = { Icon(Icons.Default.Search, null) },
                placeholder = { Text("搜索名称、型号、别名或关键词") },
                singleLine = true
            )
        }
        state.error?.let { Text(it, color = MaterialTheme.colorScheme.error) }
        if (state.loading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
            return
        }
        if (state.destination == Destination.CATEGORIES && state.selectedCategory == null) {
            LazyColumn {
                items(state.categories, key = { it.id }) { category ->
                    Row(
                        Modifier.fillMaxWidth().clickable { vm.selectCategory(category.id) }.padding(vertical = 18.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(category.title, Modifier.weight(1f), style = MaterialTheme.typography.titleLarge)
                        Text(state.entries.count { it.categoryId == category.id }.toString())
                        Icon(Icons.Default.ChevronRight, null)
                    }
                }
            }
            return
        }
        val entries = vm.visible(state)
        if (state.destination == Destination.CATEGORIES && state.selectedCategory != null) {
            TextButton({ vm.back() }) {
                Icon(Icons.Default.ArrowBack, null)
                Text("返回分类")
            }
        }
        if (entries.isEmpty()) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                Text(if (state.destination == Destination.FAVORITES) "还没有收藏条目" else "没有找到匹配内容")
            }
        } else {
            LazyColumn(contentPadding = PaddingValues(vertical = 14.dp)) {
                items(entries, key = { it.id }) { entry ->
                    Column(Modifier.fillMaxWidth().clickable { vm.open(entry) }.padding(vertical = 13.dp)) {
                        Row {
                            Text(entry.title, Modifier.weight(1f), style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                            if (state.states[entry.id]?.favorite == true) {
                                Icon(Icons.Default.Favorite, null, tint = MaterialTheme.colorScheme.primary)
                            }
                        }
                        Text(entry.englishName, color = MaterialTheme.colorScheme.primary, style = MaterialTheme.typography.labelMedium)
                        Text(entry.summary, modifier = Modifier.padding(top = 4.dp))
                    }
                    HorizontalDivider()
                }
            }
        }
    }
}

@Composable
private fun Detail(
    entry: KnowledgeEntry,
    favorite: Boolean,
    related: List<KnowledgeEntry>,
    back: () -> Unit,
    toggle: () -> Unit,
    openRelated: (KnowledgeEntry) -> Unit
) {
    val uri = LocalUriHandler.current
    LazyColumn(Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)) {
        item {
            Row {
                IconButton(back) { Icon(Icons.Default.ArrowBack, "返回") }
                Spacer(Modifier.weight(1f))
                IconButton(toggle) {
                    Icon(if (favorite) Icons.Default.Favorite else Icons.Default.FavoriteBorder, "收藏", tint = MaterialTheme.colorScheme.primary)
                }
            }
            Text(entry.title, style = MaterialTheme.typography.headlineLarge, fontWeight = FontWeight.Bold)
            Text(entry.englishName, color = MaterialTheme.colorScheme.primary)
            entry.images.firstOrNull()?.let { image ->
                AsyncImage(
                    model = "file:///android_asset/content/${image.assetPath}",
                    contentDescription = image.altText,
                    modifier = Modifier.fillMaxWidth().height(180.dp),
                    contentScale = ContentScale.Fit
                )
            }
            Text(entry.summary, style = MaterialTheme.typography.titleMedium, modifier = Modifier.padding(vertical = 18.dp))
        }
        items(entry.sections) { section ->
            Text(section.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(top = 18.dp, bottom = 8.dp))
            Text(section.body)
        }
        if (related.isNotEmpty()) {
            item {
                Text("相关器件", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
                related.forEach { item ->
                    ListItem(
                        headlineContent = { Text(item.title) },
                        supportingContent = { Text(item.englishName) },
                        trailingContent = { Icon(Icons.Default.ChevronRight, null) },
                        modifier = Modifier.clickable { openRelated(item) }
                    )
                }
            }
        }
        item {
            Text("资料来源", style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 24.dp, bottom = 8.dp))
            entry.sources.forEach { source ->
                Text("${source.publisher} · ${source.title}")
                Text(source.url, color = MaterialTheme.colorScheme.primary, modifier = Modifier.clickable { uri.openUri(source.url) }.padding(bottom = 12.dp))
            }
            entry.images.firstOrNull()?.let { image ->
                Text("图片：${image.attribution} · ${image.license}", style = MaterialTheme.typography.labelSmall)
            }
        }
    }
}
