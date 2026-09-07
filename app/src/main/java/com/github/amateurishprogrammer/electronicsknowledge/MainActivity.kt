package com.github.amateurishprogrammer.electronicsknowledge
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.github.amateurishprogrammer.electronicsknowledge.ui.KnowledgeApp
class MainActivity:ComponentActivity(){override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);setContent{KnowledgeApp()}}}
