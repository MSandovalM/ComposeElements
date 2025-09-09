package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.jetpackmsm.mylearningappone.state.CheckBoxState

@Composable
fun MyCheckBox(modifier: Modifier = Modifier) {
    var checkState by remember { mutableStateOf(false) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable { checkState = !checkState },
        contentAlignment = Alignment.Center
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(
                checked = checkState,
                onCheckedChange = {
                    checkState = it
                },
                colors = CheckboxDefaults.colors(
                    checkedColor = Color.Blue,
                    uncheckedColor = Color.Red
                ),
                enabled = true
            )
            Spacer(Modifier.height(8.dp))
            Text("Aceptar términos y condiciones")
        }
    }
}

@Composable
fun ParentCheckBoxes(modifier: Modifier = Modifier) {

    var state by remember { mutableStateOf(
        listOf(
            CheckBoxState("terms", "Aceptar los terminos"),
            CheckBoxState("newsLetter", "Suscribirse", true),
            CheckBoxState("updates", "Recibir actualizaciones")
        )
    ) }

    Column(modifier = modifier.fillMaxSize()) {
        state.forEach { myState ->
            CheckBoxVariant(checkBoxState = myState) {
                state = state.map {
                    if (it.id == myState.id) {
                        myState.copy(checked = !myState.checked)
                    } else {
                        it
                    }
                }
            }
        }
    }
}

@Composable
fun CheckBoxVariant(
    modifier: Modifier = Modifier,
    checkBoxState: CheckBoxState,
    onCheckedChange: (CheckBoxState) -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.clickable {
        onCheckedChange(checkBoxState)
    }) {
        Checkbox(
            checked = checkBoxState.checked,
            onCheckedChange = { onCheckedChange(checkBoxState) },
            enabled = true
        )
        Spacer(Modifier.width(12.dp))
        Text(checkBoxState.label)
    }
}

















