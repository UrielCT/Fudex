package com.fudex.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.fudex.ui.navigation.auth.authNavGraph
import com.fudex.ui.navigation.client.clientNavGraph
import com.fudex.ui.navigation.delivery.deliveryNavGraph
import com.fudex.ui.navigation.restaurant.restaurantNavGraph

@Composable
fun MainNavGraph(
    navController: NavHostController,
    startDestination: String
) {
    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        authNavGraph(navController)
        restaurantNavGraph(navController)
        deliveryNavGraph(navController)
        clientNavGraph(navController)
    }
}
