package com.fudex.ui.navigation.restaurant

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fudex.ui.navigation.Destination
import com.fudex.ui.navigation.client.ClientBottomBarLayout
import com.fudex.ui.screens.addEditProduct.AddEditProductScreen

fun NavGraphBuilder.restaurantNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "restaurant_root",
        route = Destination.RESTAURANT_GRAPH.route
    ) {

        composable("restaurant_root") {
            RestaurantBottomBarLayout()
        }

//        composable("restaurant_home"){
//            //ProfileScreen()
//            //MyCategoriesScreen()
//            //AddEditCategoryScreen()
//            //MyProductsScreen()
//            //MyProductDetailScreen()
//            AddEditProductScreen()
//        }


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
