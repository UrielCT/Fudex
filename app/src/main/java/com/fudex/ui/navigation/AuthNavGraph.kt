package com.fudex.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fudex.ui.screens.login.LoginScreen
import com.fudex.ui.screens.register.RegisterScreen
import com.fudex.ui.screens.roles.RolesScreen
import com.fudex.utils.Constants

fun NavGraphBuilder.authNavGraph(navController: NavHostController) {
    navigation(
        startDestination = Destination.LOGIN.route,
        route = Destination.AUTH_GRAPH.route
    ) {
        composable(Destination.LOGIN.route) {
            LoginScreen(
                navToHome = { role ->
                    when (role) {
                        "Client" -> navController.navigate(Destination.CLIENT_GRAPH.route) {
                            popUpTo(Destination.AUTH_GRAPH.route) { inclusive = true }
                        }
                        else -> navController.navigate(Destination.ROLES.route)
                    }
                },
                navToRegister = {
                    navController.navigate(Destination.REGISTER.route)
                }
            )
        }

        composable(Destination.REGISTER.route) {
            RegisterScreen(
                //navToHome = { navController.navigate("client") },
                navToHome = { role ->
                    when (role) {
                        "Client" -> navController.navigate(Destination.CLIENT_GRAPH.route) {
                            popUpTo(Destination.AUTH_GRAPH.route) { inclusive = true }
                        }
                        else -> navController.navigate(Destination.ROLES.route)
                    }
                },
                navToLogin = { navController.navigate(Destination.LOGIN.route) }
            )
        }

        composable(Destination.ROLES.route) {
            RolesScreen(
                navToOrders = { selectedRole ->
                    when (selectedRole) {
                        "Restaurant" -> navController.navigate(Destination.RESTAURANT_GRAPH) {
                            popUpTo(Destination.AUTH_GRAPH.route) { inclusive = true }
                        }
                        "Delivery" -> navController.navigate(Destination.DELIVERY_GRAPH.route) {
                            popUpTo(Destination.AUTH_GRAPH.route) { inclusive = true }
                        }
                        "Client" -> navController.navigate(Destination.CLIENT_GRAPH.route) {
                            popUpTo(Destination.AUTH_GRAPH.route) { inclusive = true }
                        }
                    }
                }
            )
        }
    }
}
