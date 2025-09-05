package com.jetpackmsm.mylearningappone.components.layouts

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyButtons(modifier: Modifier) {
    Column(modifier = modifier) {
        Button(
            onClick = { Log.i("TAG_BUTTON", "Boton pulsado") }, enabled = true,
            shape = RoundedCornerShape(20),
            border = BorderStroke(2.dp, Color.Red),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Red,
                containerColor = Color.White,
                disabledContentColor = Color.Cyan,
                disabledContainerColor = Color.Green
            )
        ) {
            Text("Pulsame")
        }

        // Cosas para no tan importantes
        OutlinedButton(
            onClick = {},
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color.Green,
                containerColor = Color.LightGray
            )
        ) {
            Text("OutLined")
        }

        TextButton(onClick = { }) {
            Text("TextButton")
        }

        ElevatedButton(onClick = {}) {
            Text("Elevated Button")
        }

        FilledTonalButton(onClick = {}) {
            Text("FilledTonalButton")
        }
    }
}