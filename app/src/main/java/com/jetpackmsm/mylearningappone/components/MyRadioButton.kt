package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyRadioButton(modifier: Modifier = Modifier) {
    var state by remember { mutableStateOf(false) }
    Row(
        modifier.padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(
            modifier = Modifier,
            selected = true,
            onClick = { state = true },
            enabled = true,
            colors = RadioButtonDefaults.colors(
                selectedColor = Color.Blue,
                unselectedColor = Color.Red
            )
        )
        Spacer(Modifier.width(2.dp))
        Text("Seleccionar", modifier.padding(horizontal = 6.dp))
    }

}

@Composable
fun MyRadioButtonList(modifier: Modifier = Modifier) {
    var selectedName by remember { mutableStateOf("") }
    Column {
        RadioButtonComp(name = "Manu", selectedName = selectedName) { selectedName = it }
        RadioButtonComp(name = "Amber", selectedName = selectedName) { selectedName = it }
        RadioButtonComp(name = "Alon", selectedName = selectedName) { selectedName = it }
        RadioButtonComp(name = "Ansper", selectedName = selectedName) { selectedName = it }
        RadioButtonComp(name = "Ale", selectedName = selectedName) { selectedName = it }
        RadioButtonComp(name = "Arama", selectedName = selectedName) { selectedName = it }
    }
}

@Composable
fun RadioButtonComp(name: String, selectedName: String, onItemSelected: (String) -> Unit) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
        onItemSelected(name)
    }) {
        RadioButton(
            selected = name == selectedName,
            onClick = { onItemSelected(name) }
        )
        Text(name)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewRadioButton(modifier: Modifier = Modifier) {
    MyRadioButtonList()
}