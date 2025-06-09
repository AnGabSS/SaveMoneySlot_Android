package com.tech.padawan.savemoneyslot.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.padawan.savemoneyslot.presentation.Home
import com.tech.padawan.savemoneyslot.presentation.Intro
import com.tech.padawan.savemoneyslot.presentation.Login

/**
 * Para um padrão mais moderno e seguro, definimos as rotas em uma "sealed class".
 * Isso evita erros de digitação nos nomes das rotas e as mantém organizadas.
 */
sealed class Screen(val route: String) {
    object Intro : Screen("intro_screen")
    object Login : Screen("login_screen")
    object Home : Screen("home_screen")
}

@Composable
fun AppNavigationController() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Intro.route
    ) {

        composable(route = Screen.Intro.route) {
            Intro(

                onAnimationFinished = {
                    navController.navigate(Screen.Login.route) {
                        popUpTo(Screen.Intro.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = Screen.Login.route) {
            Login(navController = navController)
        }

        composable(route = Screen.Home.route) {
            Home(navController = navController)
        }
    }
}
