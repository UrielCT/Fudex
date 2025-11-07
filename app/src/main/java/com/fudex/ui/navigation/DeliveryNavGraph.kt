package com.fudex.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fudex.ui.components.AppScaffold
import com.fudex.ui.screens.editProfile.EditProfileScreen
import com.fudex.ui.screens.home.HomeScreen
import com.fudex.ui.screens.orderDetail.OrderDetailScreen
import com.fudex.ui.screens.orders.OrdersScreen
import com.fudex.ui.screens.tracking.TrackingScreen

fun NavGraphBuilder.deliveryNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "delivery_home",
        route = Destination.DELIVERY_GRAPH.route
    ) {


        composable("delivery_home"){
            //OrdersScreen()
            //HomeScreen("Delivery Home")
            //EditProfileScreen()
            //OrderDetailScreen()
            TrackingScreen()

        }



//        composable("delivery_home") {
//            AppScaffold(
//                topBar = { TopBarSimple(title = "Delivery") },
//                bottomBar = { DeliveryBottomBar(navController) }
//            ) {
//                OrdersScreen()
//            }
//        }
//
//        composable("profile") { ProfileScreen() }
//        composable("edit_profile") { EditProfileScreen() }
//        composable("order_detail") { OrderDetailScreen() }
//        composable("tracking") { TrackingScreen() }

    }
}
