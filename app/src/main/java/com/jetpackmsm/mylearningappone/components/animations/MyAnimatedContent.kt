package com.jetpackmsm.mylearningappone.components.animations

import androidx.compose.animation.AnimatedContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyAnimatedContent(modifier: Modifier = Modifier) {
    var number by remember { mutableStateOf(0) }

    Column(
        Modifier
            .fillMaxSize()
            .padding(top = 48.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { number++ }
        ) { Text("Sumar") }
        Spacer(Modifier.height(32.dp))

        AnimatedContent(targetState = number) { result ->
            when(result) {
                0 -> Box(Modifier.size(50.dp).background(Color.Red)) {}
                1 -> Text("Animacion de valores")
                2 -> FloatingActionButton(onClick = {}) { Icon(imageVector = Icons.Default.Add, contentDescription =  null) }
                else -> Text("El valor es: $result")
            }
        }
    }
}