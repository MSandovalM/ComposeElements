package com.jetpackmsm.mylearningappone.components


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import com.jetpackmsm.mylearningappone.R

@Composable
fun MySwitch(modifier: Modifier = Modifier) {
    // Forma básica del switch
    var switchState by remember { mutableStateOf(true) }
    Box(modifier = modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Switch(checked = switchState,
            onCheckedChange = { switchState = it },
            thumbContent = {
                Text("A") // Muestra algo en el thumb del switch
                Icon(painter = painterResource(R.drawable.ic_launcher_foreground), contentDescription = null)
            },
            enabled = false, // Activado o desactivado
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.Red,
                uncheckedThumbColor = Color.Blue,
                disabledCheckedThumbColor = Color.Yellow,
                checkedIconColor = Color.LightGray
            )
        )
    }
}