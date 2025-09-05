package com.jetpackmsm.mylearningappone.components.layouts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation

@Composable
fun MyTextFieldParent(modifier: Modifier) {
    var value by remember { mutableStateOf("") }
    Column {
        MyPasswordTextField(value) { value = it }
    }
}

@Composable
fun MyPasswordTextField(password: String, onValueChange: (String) -> Unit) {
    var passwordHidden: Boolean by remember { mutableStateOf(true) }
    TextField(
        value = password,
        onValueChange = { onValueChange(it) },
        singleLine = true,
        label = { Text("Introduce to contraseña") },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
        trailingIcon = {
            Text(
                text = if (passwordHidden) "Mostrar" else "Ocultar",
                modifier = Modifier.clickable { passwordHidden = !passwordHidden })
        })
}