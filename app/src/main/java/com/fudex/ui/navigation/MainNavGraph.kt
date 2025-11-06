package com.fudex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost

@Composable
fun MainNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        // Flujos
        authNavGraph(navController)
        restaurantNavGraph(navController)
        deliveryNavGraph(navController)
        clientNavGraph(navController)
    }
}
