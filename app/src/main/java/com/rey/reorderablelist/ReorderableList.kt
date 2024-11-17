package com.rey.reorderablelist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch

@Composable
fun MyList(dataStoreManager: DataStoreManager) {
    val scope = rememberCoroutineScope()

    // State to track whether the DataStore data has been loaded
    var isLoading by remember { mutableStateOf(true) }

    // State for the draggable list
    var list1 by remember { mutableStateOf(emptyList<Int>()) }

    // Static list2
    val list2 by remember { mutableStateOf(List(20) { it + 20 }) }
    val draggableItems by remember { derivedStateOf { list1.size } }

    val stateList = rememberLazyListState()

    // Drag-and-drop state
    val dragDropState = rememberDragDropState(
        lazyListState = stateList,
        draggableItemsNum = draggableItems,
        onMove = { fromIndex, toIndex ->
            list1 = list1.toMutableList().apply { add(toIndex, removeAt(fromIndex)) }

            // Save updated list to DataStore
            scope.launch { dataStoreManager.saveList(list1) }
        }
    )

    // Load list1 from DataStore
    LaunchedEffect(Unit) {
        dataStoreManager.getListFlow().collect { savedList ->
            if (savedList.isNotEmpty()) {
                list1 = savedList
            } else {
                list1 = List(20) { it } // Default list if DataStore is empty
            }
            isLoading = false // Data loading complete
        }
    }

    // Show loading indicator while waiting for DataStore data
    if (isLoading) {
        CircularProgressIndicator(modifier = Modifier.fillMaxWidth().padding(16.dp))
        return
    }

    // LazyColumn for displaying the draggable list
    LazyColumn(
        modifier = Modifier.padding(top = 10.dp).dragContainer(dragDropState),
        state = stateList,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Text(text = "Reorderable List 1", fontSize = 30.sp)
        }

        draggableItems(items = list1, dragDropState = dragDropState) { modifier, item ->
            Item(modifier = modifier, index = item)
        }

        item {
            Text(text = "Reorderable List 1", fontSize = 30.sp)
        }

        draggableItems(list2, dragDropState = dragDropState) { modifier, item ->
            Item(modifier = modifier, index = item)
        }
    }
}

@Composable
private fun Item(modifier: Modifier = Modifier, index: Int) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(4.dp)
            .background(MaterialTheme.colorScheme.surface),
        shape = RoundedCornerShape(8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = "Item $index",
                    style = MaterialTheme.typography.titleMedium.copy(
                        fontWeight = FontWeight.Bold
                    )
                )
                Text(
                    text = "Description for item $index",
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Gray
                )
            }
            Icon(
                imageVector = Icons.AutoMirrored.Filled.ArrowForward,
                contentDescription = "Arrow Icon",
                tint = MaterialTheme.colorScheme.primary
            )
        }
    }
}
