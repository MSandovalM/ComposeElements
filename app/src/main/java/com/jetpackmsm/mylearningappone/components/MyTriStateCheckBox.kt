package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.state.ToggleableState
import androidx.compose.ui.unit.dp

@Composable
fun MyTriStateBox(modifier: Modifier = Modifier) {
    var parentState by remember { mutableStateOf(ToggleableState(false)) }
    var child1 by remember { mutableStateOf(false) }
    var child2 by remember { mutableStateOf(false) }

    LaunchedEffect(child1, child2) {
        parentState = when {
            child1 && child2 -> ToggleableState.On
            !child1 && !child2 -> ToggleableState.Off
            else -> ToggleableState.Indeterminate
        }
    }

    Column {
        Row {
            TriStateCheckbox(parentState, onClick = {
                val newState = parentState != ToggleableState.On
                child1 = newState
                child2 = child1
            })
            Text("Seleccionar todo")
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ){
            Checkbox(child1, onCheckedChange = {child1 = it})
            Text("Ejemplo 1")
        }
        Row (verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Checkbox(child2, onCheckedChange = {child2 = it})
            Text("Ejemplo 2")
        }
    }
}