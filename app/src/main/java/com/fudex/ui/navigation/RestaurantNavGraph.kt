package com.fudex.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fudex.ui.components.AppScaffold
import com.fudex.ui.screens.addEditCategory.AddEditCategoryScreen
import com.fudex.ui.screens.home.HomeScreen
import com.fudex.ui.screens.myProducts.MyProductsScreen
import com.fudex.ui.screens.mycategories.MyCategoriesScreen
import com.fudex.ui.screens.profile.ProfileScreen

fun NavGraphBuilder.restaurantNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "restaurant_home",
        route = Destination.RESTAURANT_GRAPH.route
    ) {

        composable("restaurant_home"){
            //HomeScreen("Restaurant Home")
            //ProfileScreen()
            //MyCategoriesScreen()
            //AddEditCategoryScreen()
            MyProductsScreen()
        }


//        composable("restaurant_home") {
//            AppScaffold(
//                topBar = { TopBarSimple(title = "Restaurant") },
//                bottomBar = { RestaurantBottomBar(navController) }
//            ) {
//                OrdersScreen()
//            }
//        }
//
//
//        composable("profile") { ProfileScreen() }
//        composable("edit_profile") { EditProfileScreen() }
//        composable("products") { ProductsScreen() }
//        composable("add_product") { AddProductScreen() }
//        composable("categories") { CategoryScreen() }
//        composable("add_category") { AddCategoryScreen() }

    }
}
