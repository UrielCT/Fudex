package com.fudex.ui.navigation.delivery

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fudex.ui.navigation.Destination
import com.fudex.ui.screens.editProfile.EditProfileScreen
import com.fudex.ui.screens.orderDetail.OrderDetailScreen
import com.fudex.ui.screens.tracking.TrackingScreen

fun NavGraphBuilder.deliveryNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "delivery_root",
        route = Destination.DELIVERY_GRAPH.route
    ) {

        composable("delivery_root") {
            DeliveryBottomBarLayout(navController)
        }

        //ORDERS
        composable(Destination.ORDER_DETAIL.route) {
            OrderDetailScreen(
                navToTracking = { navController.navigate(Destination.TRACKING.route) },
                navBack = {navController.popBackStack()}
            )
        }

        composable(Destination.TRACKING.route) {
            TrackingScreen(
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
