package com.jetpackmsm.mylearningappone.components.animations

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.jetpackmsm.mylearningappone.components.navigation.Detail
import com.jetpackmsm.mylearningappone.components.navigation.examples.DetailScreen
import com.jetpackmsm.mylearningappone.components.navigation.examples.HomeScreen
import com.jetpackmsm.mylearningappone.components.navigation.examples.LoginScreen

@Composable
fun MyCrossFade( ) {
    var currentScreen by remember { mutableStateOf("Home") }

    Column {
        Row(
            Modifier
                .padding(top = 64.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text("Home", Modifier.clickable { currentScreen = "Home" })
            Text("Detail", Modifier.clickable { currentScreen = "Detail" })
            Text("Login", Modifier.clickable { currentScreen = "Login" })
        }

        Crossfade(
            targetState = currentScreen
        ) { screen ->
            when (screen) {
                "Home" -> HomeScreen(navigateBack = {}, navigateToDetail = { _, _ -> })
                "Detail" -> DetailScreen(id = "Manuel") { }
                "Login" -> LoginScreen { }
            }
        }
    }
}