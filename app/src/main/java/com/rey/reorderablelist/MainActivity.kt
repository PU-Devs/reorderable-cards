package com.rey.reorderablelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.lifecycle.lifecycleScope
import com.rey.reorderablelist.ui.theme.ReorderableListTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val dataStoreManager by lazy { DataStoreManager(applicationContext) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        lifecycleScope.launch {
            // Initialize the DataStore with default list if empty
            dataStoreManager.initializeListIfEmpty(List(20) { it })
        }

        setContent {
            ReorderableListTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MyList(dataStoreManager)
                }
            }
        }
    }
}
