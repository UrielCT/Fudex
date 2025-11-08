package com.fudex.ui.navigation.restaurant

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Category
import androidx.compose.material.icons.filled.Fastfood
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
import com.fudex.ui.screens.addEditCategory.AddEditCategoryScreen
import com.fudex.ui.screens.addEditProduct.AddEditProductScreen
import com.fudex.ui.screens.myProducts.MyProductsScreen
import com.fudex.ui.screens.mycategories.MyCategoriesScreen
import com.fudex.ui.screens.orders.OrdersScreen
import com.fudex.ui.screens.profile.ProfileScreen

@Composable
fun RestaurantBottomBarLayout() {
    val navController = rememberNavController()

    Scaffold(
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
            composable("categories") { MyCategoriesScreen() }
            composable("products") { MyProductsScreen() }
            composable("orders") { OrdersScreen() }
            composable("profile") { ProfileScreen() }

            // Pantallas sin BottomBar
            composable("add_edit_product") { AddEditProductScreen() }
            composable("add_edit_category") { AddEditCategoryScreen() }
        }
    }
}