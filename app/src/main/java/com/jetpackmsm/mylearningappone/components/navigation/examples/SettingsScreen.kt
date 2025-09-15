package com.jetpackmsm.mylearningappone.components.navigation.examples

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.jetpackmsm.mylearningappone.components.navigation.examples.model.SettingsModel

@Composable
fun SettingsScreen(settingsModel: SettingsModel, navigateBack: () -> Unit) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally){
        Spacer(Modifier.weight(1f))
        Text("Settings: ID: ${settingsModel.id}, Dark Mode: ${settingsModel.darkMode}", fontSize = 30.sp)
        Spacer(Modifier.weight(1f))
        Button(onClick = {
            navigateBack()
        }) {
            Text("Volver al inicio")
        }
        Spacer(Modifier.weight(1f))
    }
}