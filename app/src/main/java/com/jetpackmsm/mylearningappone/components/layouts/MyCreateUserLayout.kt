package com.jetpackmsm.mylearningappone.components.layouts

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Composable
fun CreateUserLayout(modifier: Modifier) {
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var lastname by remember { mutableStateOf("") }

    Column (modifier.padding(32.dp)) {
        NameTextField(name, "Introduce tu nombre") { name = it }
        Spacer(modifier.height(16.dp))
        NameTextField(surname, "Introduce tu apellido") { surname = it }
        Spacer(modifier.height(16.dp))
        NameTextField(lastname, "Introduce tu segundo apellido") { lastname = it }
        Spacer(modifier.height(32.dp))
        SaveUserInfo()
    }
}

@Composable
fun NameTextField(name: String, label: String, onValueChange: (String) -> Unit) {
    TextField(
        value = name,
        onValueChange = {onValueChange(it)},
        singleLine = true,
        label = {
            Text(text = label)
        }
    )
}

@Composable
fun SaveUserInfo() {
    Row(modifier =  Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween) {
        Button(
            onClick = {}
        ) {
            Text("Guardar usuario")
        }

        Spacer(modifier = Modifier.width(8.dp))

        FilledTonalButton(
            onClick = {}
        ) {
            Text("Cancelar")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewCreateUserLayout() {
    CreateUserLayout(Modifier)
}
