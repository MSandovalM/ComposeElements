package com.jetpackmsm.mylearningappone.state

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier


@Composable
fun MyHoistingState(modifier: Modifier) {
    var number by rememberSaveable { mutableIntStateOf(0) }

    Column(modifier = modifier) {
        StateExample1(number) { number += 1 }
        StateExample2(number = number, onClick = { number += 1 })
    }

}

@Composable
fun StateExample1(number: Int, onClick: () -> Unit) {
    Text("Púlsame: $number", modifier = Modifier.clickable { onClick() })
}

@Composable
fun StateExample2(number: Int, onClick: () -> Unit) {
    Text("Púlsame: $number", modifier = Modifier.clickable { onClick() })
}

@Composable
fun MyState(modifier: Modifier) {
    var number = remember { mutableIntStateOf(0) }

    Column {
        Text("Valor: ${number.intValue}", modifier.clickable { number.intValue += 1 })
        Text("Valor: ${number.intValue}", modifier.clickable { number.intValue += 1 })
    }

}

@Composable
fun MyStateSave(modifier: Modifier) {
    val number = rememberSaveable { mutableIntStateOf(0) }

    Column {
        Text("Valor: ${number.intValue}", modifier.clickable { number.intValue += 1 })
        Text("Valor: ${number.intValue}", modifier.clickable { number.intValue += 1 })
    }

}

@Composable
fun MyStateSaveBy(modifier: Modifier) {
    var number by rememberSaveable { mutableIntStateOf(0) }

    Column {
        Text("Valor: $number", modifier.clickable { number += 1 })
        Text("Valor: $number", modifier.clickable { number += 1 })
    }

}