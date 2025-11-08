package com.fudex.ui.navigation.delivery

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fudex.ui.navigation.BottomNavItem
import com.fudex.ui.navigation.RoleBottomBar
import com.fudex.ui.screens.orderDetail.OrderDetailScreen
import com.fudex.ui.screens.orders.OrdersScreen
import com.fudex.ui.screens.profile.ProfileScreen
import com.fudex.ui.screens.tracking.TrackingScreen


@Composable
fun DeliveryBottomBarLayout() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            RoleBottomBar(
                items = listOf(
                    BottomNavItem("orders", Icons.Default.List, "Pedidos"),
                    BottomNavItem("profile", Icons.Default.Person, "Perfil")
                ),
                navController = navController
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "orders",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("orders") { OrdersScreen() }
            composable("profile") { ProfileScreen() }

            // Pantallas fuera del BottomBar
            composable("tracking") { TrackingScreen() }
            composable("order_detail") { OrderDetailScreen() }
        }
    }
}
