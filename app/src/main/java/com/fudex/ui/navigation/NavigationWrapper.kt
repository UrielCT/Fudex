package com.fudex.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.fudex.ui.screens.login.LoginScreen

@Composable
fun Navigationwrapper(
    navController: NavHostController,
    modifier: Modifier
){


    NavHost(
        navController = navController,
        startDestination = Destination.LOGIN
    ) {

        composable(Destination.LOGIN.route) {
            LoginScreen(
                navToHome = {},
                navToRegister = {}
            )
        }

    }
}