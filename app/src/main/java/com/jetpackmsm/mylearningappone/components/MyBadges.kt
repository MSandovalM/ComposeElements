package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MyBadge(modifier: Modifier = Modifier) {
    Badge(
        modifier,
        containerColor = Color.Blue,
        contentColor = Color.White
    ) {
        Text("5")
    }
}

@Composable
fun MyBadgeBox(modifier: Modifier = Modifier) {
    BadgedBox(badge = { MyBadge() }) {
        Icon(imageVector = Icons.Default.ShoppingCart, contentDescription = null)
    }
}

@Preview(showBackground = true)
@Composable
private fun PreviewMyBadge() {
    Column(Modifier.fillMaxSize()) {
        MyBadge()
        Spacer(Modifier.height(20.dp))
        MyBadgeBox()
    }
}