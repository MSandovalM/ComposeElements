package com.jetpackmsm.mylearningappone.components.layouts

import android.widget.CheckBox
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
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
            Text("Aceptar términos y condiciones")
        }
    }
}