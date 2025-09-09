@file:OptIn(ExperimentalMaterial3Api::class)

package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RangeSlider
import androidx.compose.material3.RangeSliderState
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.SliderState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MySlider(modifier: Modifier = Modifier) {
    val myValue by remember { mutableFloatStateOf(0f) }
    val value = 0.75f
    Column(modifier = modifier.padding(horizontal = 30.dp)) {
        Slider(
            value = value, //myValue
            onValueChange = {},
            colors = SliderDefaults.colors(
                activeTrackColor = Color.Gray
            )
        )
        Text(value.toString())
    }
}


@Composable
fun MyAdvancedSlider(modifier: Modifier = Modifier) {
    var example by remember { mutableStateOf("+") }
    val state = remember { SliderState(
        value = 5f,
        valueRange = 0f .. 10f,
        steps = 9,
        onValueChangeFinished = {
            example = " - "
        }
    ) }

    Column (modifier = modifier
        .padding(horizontal = 30.dp)) {
        Slider(state)
        Text(state.value.toString())
        Text(example)
    }
}

@Composable
fun MyRangeSlider(modifier: Modifier = Modifier) {
    val stateRange = remember {
        RangeSliderState(
            activeRangeStart = 3f,
            activeRangeEnd = 6f,
            valueRange = 0f .. 10f,
            steps = 9
        )
    }
    Column (modifier.padding(horizontal = 30.dp)) {
        RangeSlider(stateRange,
            startThumb = {
                Box(
                    Modifier.size(40.dp).clip(CircleShape).background(Color.LightGray),
                    contentAlignment = Alignment.Center
                ) {
                    Text(it.activeRangeStart.toString())
                }
            },
            endThumb = {
                Box(Modifier.size(40.dp).clip(CircleShape).background(Color.Magenta),
                    contentAlignment = Alignment.Center)
                {
                    Text(it.activeRangeEnd.toString())
                }
            })
        Text(stateRange.activeRangeStart.toString())
        Text(stateRange.activeRangeEnd.toString())
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMySlider(modifier: Modifier = Modifier) {
    Column (modifier.padding(vertical = 12.dp)) {
        MySlider(modifier)
        MyAdvancedSlider(modifier)
        MyRangeSlider(modifier)
    }
}