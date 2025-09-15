package com.jetpackmsm.mylearningappone.components.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.jetpackmsm.mylearningappone.components.navigation.examples.DetailScreen
import com.jetpackmsm.mylearningappone.components.navigation.examples.HomeScreen
import com.jetpackmsm.mylearningappone.components.navigation.examples.LoginScreen

@Composable
fun NavigationWrapper(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Login ) {
        composable<Login> {
            LoginScreen(
                navigateToHome = {
                    navController.navigate(Home)
                }
            )
        }

        composable<Home> {
            HomeScreen(
                navigateBack = {
                    navController.popBackStack()
                },
                navigateToDetail = { id, test ->
                    navController.navigate(Detail(id = id, test = test))
                }
            )
        }

        composable<Detail> { navBackStackEntry ->
            val detail: Detail = navBackStackEntry.toRoute()
            // detail.test
            DetailScreen(detail.id, navigateToHome = {
                navController.navigate(Home)
            })
        }
    }
}