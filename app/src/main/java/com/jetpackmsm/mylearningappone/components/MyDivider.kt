package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyDivider(modifier: Modifier = Modifier) {
    Column(modifier.padding(20.dp)) {
        Text("Parte de arriba")
        HorizontalDivider(thickness = 3.dp, color = Color.Black)
        Text("Parte de abajo")
        Row (modifier = Modifier.height(40.dp)){
            Text("Izquierda")
            VerticalDivider(color = Color.Blue)
            Text("Derecha")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMyDivider() {
    MyDivider()
}