package com.jetpackmsm.mylearningappone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.jetpackmsm.mylearningappone.components.MyAlertDialog
import com.jetpackmsm.mylearningappone.components.MyCustomDialog
import com.jetpackmsm.mylearningappone.components.MyFloatingActionButton
import com.jetpackmsm.mylearningappone.components.MyModalDrawer
import com.jetpackmsm.mylearningappone.components.MyNavigationBar
import com.jetpackmsm.mylearningappone.components.MyProgressBar
import com.jetpackmsm.mylearningappone.components.MyTopAppBar
import com.jetpackmsm.mylearningappone.components.model.PokemonCombat
import com.jetpackmsm.mylearningappone.components.navigation.NavigationWrapper
import com.jetpackmsm.mylearningappone.ui.theme.MyLearningAppOneTheme
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyLearningAppOneTheme {
                val snackbarHostState = remember { SnackbarHostState() }
                val scope = rememberCoroutineScope()
                val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

                var showDialog by remember { mutableStateOf(false) }
                val pokemonCombat = PokemonCombat("Charmeleon", "Gastly")

                MyCustomDialog(
                    showDialog = showDialog,
                    pokemonCombat = pokemonCombat,
                    onStartCombat = {
                        showDialog = false
                    },
                    onDismissDialog = {
                        showDialog = false
                    }
                )
                NavigationWrapper()

//                MyAlertDialog()
//                MyModalDrawer (drawerState) {
//                    Scaffold(
//                        modifier = Modifier.fillMaxSize(),
//                        topBar = {
//                            MyTopAppBar {
//                                scope.launch {
//                                    drawerState.open()
//                                }
//                            }
//                        },
//                        snackbarHost = {
//                            SnackbarHost(hostState = snackbarHostState)
//                        },
//                        floatingActionButton = {
//                            MyFloatingActionButton()
//                        },
//                        bottomBar = { MyNavigationBar() }
//                    ) { innerPadding ->
//                        Box(
//                            modifier = Modifier
//                                .fillMaxSize()
//                                .background(Color.Cyan)
//                                .padding(innerPadding),
//                            contentAlignment = Alignment.Center
//                        ) {
//                            Text("Esta es mi Screen", modifier = Modifier.clickable {
//                                scope.launch {
//                                    val result = snackbarHostState.showSnackbar(
//                                        message = "Ejemplo",
//                                        actionLabel = "Deshacer"
//                                    )
//
//                                    if (result == SnackbarResult.ActionPerformed) {
//                                        // Pulso Deshacer
//                                    } else {
//                                        // No pulsó nada
//                                    }
//                                }
//                            })
//                        }
//                    }
//                }
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