package com.jetpackmsm.mylearningappone.components.advanced

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MyDerivedState(modifier: Modifier = Modifier) {
    var email by remember { mutableStateOf("") }
    var pass by remember { mutableStateOf("") }

    val isFormValid by remember(email, pass) {
        derivedStateOf {
            email.contains("@") && pass.length > 4
        }
    }

    // email.contains("@") && pass.length > 4

    Column(modifier = Modifier.background(Color.White)) {
        TextField(value = email, onValueChange = { email = it })
        Spacer(Modifier.height(4.dp))
        TextField(value = pass, onValueChange = { pass = it })
        Spacer(Modifier.height(24.dp))
        Button(
            onClick = {

            },
            enabled = isFormValid
        ) {
            Text("Login")
        }
    }

}