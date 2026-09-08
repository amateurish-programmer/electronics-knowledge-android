package com.github.amateurishprogrammer.electronicsknowledge.data
import android.content.Context
import androidx.datastore.preferences.core.*
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.map
private val Context.store by preferencesDataStore("settings")
class ThemeStore(private val context:Context){private val key=booleanPreferencesKey("dark");val dark=context.store.data.map{it[key]};suspend fun set(value:Boolean){context.store.edit{it[key]=value}}}
