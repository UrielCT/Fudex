package com.fudex.ui.navigation.client

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fudex.ui.navigation.BottomNavItem
import com.fudex.ui.navigation.Destination
import com.fudex.ui.navigation.RoleBottomBar
import com.fudex.ui.screens.home.HomeScreen
import com.fudex.ui.screens.orders.OrdersScreen
import com.fudex.ui.screens.profile.ProfileScreen


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ClientBottomBarLayout(parentNavController: NavHostController) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route


    Scaffold(
        topBar = {
            if (currentRoute == "home") {
                TopAppBar(
                    title = { Text("Categorías") },
                    actions = {
                        IconButton(onClick = { parentNavController.navigate(Destination.CART.route) }) {
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Carrito",
                                tint = MaterialTheme.colorScheme.onBackground
                            )
                        }
                    },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        titleContentColor = MaterialTheme.colorScheme.onBackground
                    )
                )
            }
        },
        bottomBar = {
            RoleBottomBar(
                items = listOf(
                    BottomNavItem("home", Icons.Default.Home, "Inicio"),
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
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") {
                HomeScreen(
                    navToProducts = { parentNavController.navigate(Destination.PRODUCTS.route) }
                )
            }
            composable("orders") {
                OrdersScreen(
                    navToOrderDetail = { parentNavController.navigate(Destination.ORDER_DETAIL.route) }
                )
            }
            composable("profile") {
                ProfileScreen(
                    navToEditProfile = { parentNavController.navigate(Destination.EDIT_PROFILE.route) }
                )
            }
        }
    }
}


//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun ClientBottomBarLayout(parentNavController: NavHostController) {
//    val navController = rememberNavController()
//
//    val currentDestination = navController
//        .currentBackStackEntryAsState()
//        .value?.destination?.route
//
//    val activity = (LocalContext.current as? Activity)
//
//    // 🔹 Manejo del botón atrás del sistema
//    BackHandler(enabled = currentDestination in listOf("home", "orders", "profile")) {
//        activity?.finish() // salir de la app
//    }
//
//
//    val showCartIcon = currentDestination == "home"
//
//    Scaffold(
//
//        topBar = {
//            if (currentDestination == "home") {
//                TopAppBar(
//                    title = { Text("Categorías") },
//                    actions = {
//                        IconButton(onClick = { parentNavController.navigate(Destination.CART.route) }) {
//                            Icon(
//                                imageVector = Icons.Default.ShoppingCart,
//                                contentDescription = "Carrito",
//                                tint = MaterialTheme.colorScheme.onBackground
//                            )
//                        }
//                    },
//                    colors = TopAppBarDefaults.topAppBarColors(
//                        containerColor = MaterialTheme.colorScheme.background,
//                        titleContentColor = MaterialTheme.colorScheme.onBackground
//                    )
//                )
//            }
//        },
//
//        bottomBar = {
//            RoleBottomBar(
//                items = listOf(
//                    BottomNavItem("home", Icons.Default.Home, "Inicio"),
//                    BottomNavItem("orders", Icons.Default.List, "Pedidos"),
//                    BottomNavItem("profile", Icons.Default.Person, "Perfil")
//                ),
//                navController = navController
//            )
//        },
//        containerColor = MaterialTheme.colorScheme.background
//    ) { innerPadding ->
//        NavHost(
//            navController = navController,
//            startDestination = "home",
//            modifier = Modifier.padding(innerPadding)
//        ) {
//            //main screens
//            composable("home") {
//                HomeScreen(
//                    navToProducts = { parentNavController.navigate(Destination.PRODUCTS.route) }
//                    //navToCart = { parentNavController.navigate("cart") }
//                )
//            }
//            composable("orders") {
//                OrdersScreen(
//                    navToOrderDetail = { parentNavController.navigate(Destination.ORDER_DETAIL.route) }
//                )
//            }
//            composable("profile") {
//                ProfileScreen(
//                    navToEditProfile = { parentNavController.navigate(Destination.EDIT_PROFILE.route) }
//                )
//            }
//
//        }
//    }
//}
