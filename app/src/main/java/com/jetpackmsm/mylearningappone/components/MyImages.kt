package com.jetpackmsm.mylearningappone.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.jetpackmsm.mylearningappone.R

@Preview(showBackground = true)
@Composable
fun MyImage() {
    Column {
//        Image(
//            painter = painterResource(R.drawable.ic_launcher_foreground),
//            contentDescription = "Avatar image profile",
//            modifier = Modifier
//                .height(200.dp)
//                .width(30.dp),
//            contentScale = ContentScale.Inside
//        )
        Image(
            painter = painterResource(R.drawable.mini_dos),
            contentDescription = "Avatar image profile",
            modifier = Modifier
                .size(200.dp)
                //.clip(RoundedCornerShape(topEnd = 100.dp, topStart = 40.dp)),
                //.clip(CircleShape),
                .clip(RoundedCornerShape(50))
                .border(
                    width = 5.dp,
                    shape = CircleShape,
                    brush = Brush.linearGradient(
                        colors = listOf(
                            Color.Green, Color.Red, Color.Blue
                        )
                    )
                ),
            contentScale = ContentScale.Fit
        )
    }
}