package com.fudex.ui.navigation.restaurant

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fudex.ui.navigation.Destination
import com.fudex.ui.screens.addEditCategory.AddEditCategoryScreen
import com.fudex.ui.screens.addEditProduct.AddEditProductScreen
import com.fudex.ui.screens.editProfile.EditProfileScreen
import com.fudex.ui.screens.myProductDetail.MyProductDetailScreen
import com.fudex.ui.screens.orderDetail.OrderDetailScreen

fun NavGraphBuilder.restaurantNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "restaurant_root",
        route = Destination.RESTAURANT_GRAPH.route
    ) {

        composable("restaurant_root") {
            RestaurantBottomBarLayout(navController)
        }

        //MY CATEGORIES
        composable(Destination.ADD_EDIT_CATEGORIES.route) {
            AddEditCategoryScreen(
                //navToTracking = { navController.navigate(Destination.TRACKING.route) },
                navBack = {navController.popBackStack()}
            )
        }

        //MY PRODUCTS
        composable(Destination.MY_PRODUCT_DETAIL.route) {
            MyProductDetailScreen(
                navToAddEditProduct = { navController.navigate(Destination.ADD_EDIT_PRODUCT.route) },
                navBack = {navController.popBackStack()}
            )
        }

        composable(Destination.ADD_EDIT_PRODUCT.route) {
            AddEditProductScreen(
                navBack = {navController.popBackStack()}
            )
        }

        //ORDERS
        composable(Destination.ORDER_DETAIL.route) {
            OrderDetailScreen(
                //navToTracking = { navController.navigate(Destination.TRACKING.route) },
                navBack = {navController.popBackStack()}
            )
        }


        //PROFILE
        composable(Destination.EDIT_PROFILE.route) {
            EditProfileScreen(
                navBack = {navController.popBackStack()}
            )
        }

    }
}
