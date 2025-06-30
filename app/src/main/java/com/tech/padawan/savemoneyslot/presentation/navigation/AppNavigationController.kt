package com.tech.padawan.savemoneyslot.presentation.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.tech.padawan.savemoneyslot.presentation.Home
import com.tech.padawan.savemoneyslot.presentation.Intro
import com.tech.padawan.savemoneyslot.presentation.Login
import com.tech.padawan.savemoneyslot.presentation.components.SideNavMenu
import com.tech.padawan.savemoneyslot.presentation.transaction.Transactions


sealed class Screen(val route: String) {
    object Intro : Screen("intro_screen")
    object Login : Screen("login_screen")
    object Home : Screen("home_screen")
    object Transactions: Screen("transactions_screen")
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
            SideNavMenu(screenName = "Home", navController = navController) {
                Home(navController = navController)
            }
        }

        composable( route = Screen.Transactions.route) {
            SideNavMenu(screenName = "Transactions", navController = navController) {
                Transactions(navController = navController)
            }
        }
    }
}
