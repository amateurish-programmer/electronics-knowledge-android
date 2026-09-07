package com.github.amateurishprogrammer.electronicsknowledge.ui
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
private val Dark=darkColorScheme(primary=Color(0xFF28D7A1),background=Color(0xFF0D1417),surface=Color(0xFF111B20),onBackground=Color(0xFFE2ECE8),onSurface=Color(0xFFE2ECE8))
private val Light=lightColorScheme(primary=Color(0xFF006C50),background=Color(0xFFF7FAF8),surface=Color.White,onBackground=Color(0xFF17201D),onSurface=Color(0xFF17201D))
@Composable
fun KnowledgeTheme(dark:Boolean,content:@Composable ()->Unit){
    MaterialTheme(colorScheme=if(dark)Dark else Light,typography=Typography(),content=content)
}
