package com.rey.reorderablelist

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("reorderable_list")

class DataStoreManager(private val context: Context) {

    companion object {
        private const val LIST_SIZE = 20
        private val ITEM_KEYS = List(LIST_SIZE) { intPreferencesKey("item_$it") }
    }

    // Retrieve list as Flow
    fun getListFlow(): Flow<List<Int>> {
        return context.dataStore.data.map { prefs ->
            ITEM_KEYS.mapNotNull { key -> prefs[key] }
        }
    }

    // Save list to DataStore
    suspend fun saveList(list: List<Int>) {
        context.dataStore.edit { prefs ->
            ITEM_KEYS.forEachIndexed { index, key ->
                prefs[key] = list.getOrNull(index) ?: -1
            }
        }
    }

    // Initialize DataStore with default list if empty
    suspend fun initializeListIfEmpty(defaultList: List<Int>) {
        context.dataStore.edit { prefs ->
            if (ITEM_KEYS.all { key -> prefs[key] == null }) {
                ITEM_KEYS.forEachIndexed { index, key ->
                    prefs[key] = defaultList.getOrNull(index) ?: -1
                }
            }
        }
    }
}
