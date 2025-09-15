package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.key
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import kotlin.random.Random

@Composable
fun MyBasicList(modifier: Modifier = Modifier, onItemClick: (String) -> Unit) {
    val names = listOf(
        "Manuel",
        "Alejandra",
        "Xochitl",
        "Villa",
        "Manuel",
        "Alejandra",
        "Xochitl",
        "Villa",
        "Manuel",
        "Alejandra",
        "Xochitl",
        "Villa",
        "Manuel",
        "Alejandra",
        "Xochitl",
        "Villa",
        "Manuel",
        "Alejandra",
        "Xochitl",
        "Villa",
        "Manuel",
        "Alejandra",
        "Xochitl",
        "Villa",
    )

    // Usamos LazyColumn para que solo cargue los que se puedan ver en pantalla

    LazyColumn {
        items(names) {
            Text(
                it, modifier = modifier
                    .padding(24.dp)
                    .clickable {
                        onItemClick(it)
                    })
        }
    }

    LazyRow {
        items(names) {
            Text(text = it, modifier = modifier.clickable {
                onItemClick(it)
            })
        }
    }

}

@Composable
fun MyAdvancedList(modifier: Modifier = Modifier) {
    var items by remember {
        mutableStateOf(
            List(100) { "Item número $it" }
        )
    }

    LazyColumn {
        item {
            Button({
                items.toMutableList().apply {
                    add(0, "Hello")
                }
            }) { Text("Hola") }
        }
        // SIEMPRE PONER EL KEY para cuando vayas a modificar una lista
        itemsIndexed(items, key = { _, item -> item }) { index, item ->
            Row {
                Text(text = item + "Indice: $index")
                Spacer(Modifier.weight(1f))
                TextButton({
                    items = items.toMutableList().apply {
                        remove(item)
                    }
                }) { Text("Borrar") }
                Spacer(Modifier.width(24.dp))
            }
        }
    }
}

@Composable
fun MyScrollList(modifier: Modifier = Modifier) {
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    val showButton by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex > 5
        }
    }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        LazyColumn(state = listState) {
            items(100) {
                Text("Item: $it", modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp))
            }
        }
        if (showButton) {
            FloatingActionButton(onClick = {
                coroutineScope.launch {
                    listState.animateScrollToItem(0)
                    // listState.scrollToItem(0)
                }
            }, modifier = Modifier.padding(16.dp)
            ) {
                Icon(imageVector = Icons.Default.Home, contentDescription = null)
            }
        }
    }

}

@Composable
fun MyGridList(modifier: Modifier = Modifier) {
    val numbers = remember { mutableStateOf(List(50) { Random.nextInt(0, 6) }) }
    val colors = listOf(
        Color(0xFFE57373),
        Color(0xFFFFB74D),
        Color(0xFFFFF176),
        Color(0xFF81C784),
        Color(0xFF64B5F6),
        Color(0xFFBA68C8)
    )

    // LazyHorizontalGrid(rows = GridCells.Fixed(4) { }

    LazyVerticalGrid(
        columns = GridCells.Adaptive(80.dp), // GridCells.Fixed(3)
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.spacedBy(5.dp),
        horizontalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(numbers.value) { randomNumber ->
            Box(
                modifier = Modifier.background(colors[randomNumber]).height(80.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(randomNumber.toString(), color = Color.White, fontSize = 24.sp)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMyBasicList() {
    MyGridList()
}
