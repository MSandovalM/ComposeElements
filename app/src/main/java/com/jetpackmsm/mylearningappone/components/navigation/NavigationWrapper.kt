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
import com.jetpackmsm.mylearningappone.components.navigation.examples.SettingsScreen
import com.jetpackmsm.mylearningappone.components.navigation.examples.model.SettingsModel
import com.jetpackmsm.mylearningappone.components.navigation.types.createNavType
import com.jetpackmsm.mylearningappone.components.navigation.types.settingsModelType
import kotlin.reflect.typeOf

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
            DetailScreen(id = detail.id, navigateToSettings = {
                navController.navigate(Settings(it))
            })
        }

        composable<Settings>(typeMap = mapOf(typeOf<SettingsModel>() to createNavType<SettingsModel>())) {
            navBackStackEntry ->
            val settings = navBackStackEntry.toRoute<Settings>()
           SettingsScreen(
               settingsModel = settings.settingsModel,
               navigateBack = { navController.navigate(Login) { // Esta es la manera correcta de regresar a la pantalla de home y quitar del stack las demas vistas
                   popUpTo<Login>{inclusive = true} // Incluye el primer login que se creo, es decir que estamos recreando la pantalla con el inclusive
               }}
           )
        }
    }
}