package com.fudex.ui.navigation.restaurant

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Fastfood
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.fudex.ui.navigation.BottomNavItem
import com.fudex.ui.navigation.Destination
import com.fudex.ui.navigation.RoleBottomBar
import com.fudex.ui.screens.myProducts.MyProductsScreen
import com.fudex.ui.screens.mycategories.MyCategoriesScreen
import com.fudex.ui.screens.orders.OrdersScreen
import com.fudex.ui.screens.profile.ProfileScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantBottomBarLayout(parentNavController: NavHostController) {
    val navController = rememberNavController()
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    Scaffold(

        topBar = {
            if (currentRoute == "categories" || currentRoute == "products") {
                TopAppBar(
                    title = { Text( if(currentRoute == "categories") "Mis Categorías" else "Mis Productos" ) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.background,
                        titleContentColor = MaterialTheme.colorScheme.onBackground
                    )
                )
            }
        },

        floatingActionButton = {
            if (currentRoute == "categories" || currentRoute == "products") {
                FloatingActionButton(
                    onClick = {
                        if (currentRoute == "categories") {
                            parentNavController.navigate(Destination.ADD_EDIT_CATEGORIES.route)
                        } else {
                            parentNavController.navigate(Destination.ADD_EDIT_PRODUCT.route)
                        }
                    },
                    containerColor = MaterialTheme.colorScheme.primary,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Agregar"
                    )
                }
            }
        },
        bottomBar = {
            RoleBottomBar(
                items = listOf(
                    BottomNavItem("categories", Icons.Default.Category, "Categorías"),
                    BottomNavItem("products", Icons.Default.Fastfood, "Productos"),
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
            startDestination = "categories",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("categories") {
                MyCategoriesScreen(
                    navToEditCategory = { parentNavController.navigate(Destination.ADD_EDIT_CATEGORIES.route) },
                    navToAddCategory = { parentNavController.navigate(Destination.ADD_EDIT_CATEGORIES.route) },
                )
            }

            composable("products") {
                MyProductsScreen(
                    navToMyProductDetail = { parentNavController.navigate(Destination.MY_PRODUCT_DETAIL.route) },
                    navToAddProduct = { parentNavController.navigate(Destination.ADD_EDIT_PRODUCT.route) },
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