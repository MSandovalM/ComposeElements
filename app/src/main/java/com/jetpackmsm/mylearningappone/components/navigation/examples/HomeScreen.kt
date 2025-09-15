package com.jetpackmsm.mylearningappone.components.navigation.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

@Composable
fun HomeScreen(navigateBack: () -> Unit, navigateToDetail: (String, Boolean) -> Unit) {
    var text by remember { mutableStateOf("") }
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(Modifier.weight(1f))
        Text("Home Screen", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Row( verticalAlignment = Alignment.CenterVertically) {
            TextField(value = text, onValueChange = {text = it }, modifier = Modifier.weight(1f))
            Button(
                onClick = {
                    navigateToDetail(text, true)
                }
            ) { Text("Detail") }
        }
        Spacer(Modifier.weight(1f))
        Button(onClick = {
            navigateBack()
        }) {
            Text("Salir de navegacion")
        }
        Spacer(Modifier.weight(1f))
    }
}


@Preview(showBackground = true)
@Composable
private fun PreviewHomeScreen() {
    HomeScreen(navigateBack = {}) { _, _ ->

    }
}