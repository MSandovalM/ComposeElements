package com.jetpackmsm.mylearningappone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackmsm.mylearningappone.components.layouts.FirstExercise
import com.jetpackmsm.mylearningappone.components.layouts.MyProgressBar
import com.jetpackmsm.mylearningappone.ui.theme.MyLearningAppOneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyLearningAppOneTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MyProgressBar(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MyLearningAppOneTheme {
        Greeting("Aloha hawwaii")
    }
}