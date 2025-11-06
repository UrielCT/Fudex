package com.fudex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fudex.ui.screens.login.LoginScreen
import com.fudex.ui.screens.register.RegisterScreen
import com.fudex.ui.screens.roles.RolesScreen

@Composable
fun Navigationwrapper(
    navController: NavHostController,
    modifier: Modifier
){


    NavHost(
        navController = navController,
        startDestination = Destination.REGISTER
    ) {

        composable(Destination.LOGIN.route) {
            LoginScreen(
                navToHome = {},
                navToRegister = {}
            )
        }

        composable(Destination.REGISTER.route) {
            RegisterScreen (
                navToHome = {},
                navToLogin = {}
            )
        }

        composable(Destination.ROLES.route) {
            RolesScreen (
                navToOrders = {},
            )
        }

    }
}