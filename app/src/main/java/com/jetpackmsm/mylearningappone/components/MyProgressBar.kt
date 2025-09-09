package com.jetpackmsm.mylearningappone.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun MyProgressBar(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CircularProgressIndicator(
            Modifier.size(140.dp),
            color = Color.Red,
            strokeWidth = 5.dp,
            trackColor = Color.Blue,
            strokeCap = StrokeCap.Round
        )
        MyLinearProgress()
    }
}

@Composable
fun MyLinearProgress(modifier: Modifier = Modifier) {
    Spacer(Modifier.height(24.dp))
    LinearProgressIndicator(
        color = Color.Red,
        trackColor = Color.Blue,
        strokeCap = StrokeCap.Round
    )
}

@Composable
fun ProgressAdvanced(modifier: Modifier = Modifier) {
    var progress by remember { mutableFloatStateOf(0.0f) }
    val animatedProgress by animateFloatAsState(targetValue = progress)
    var isLoading = false
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (isLoading){
            CircularProgressIndicator(
                { animatedProgress },
                Modifier.size(140.dp)
            )
        }
        LinearProgressIndicator(
            progress = { animatedProgress },
            Modifier.size(50.dp),
            color = Color.Red,
            trackColor = Color.Blue
        )
        Spacer(modifier.height(16.dp))
        Row (modifier.padding(24.dp)){
            Button(onClick = {progress-=0.1f}) { Text("<-") }
            Spacer(Modifier.width(24.dp))
            Button(onClick = {progress+=0.1f}) { Text("->") }
        }
        Button(onClick = {isLoading = !isLoading}) { Text("Show/Hide") }
    }
}