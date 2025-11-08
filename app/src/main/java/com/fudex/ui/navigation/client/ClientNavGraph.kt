package com.fudex.ui.navigation.client

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fudex.ui.navigation.Destination
import com.fudex.ui.screens.cart.CartScreen
import com.fudex.ui.screens.directionMap.DirectionMapScreen
import com.fudex.ui.screens.editProfile.EditProfileScreen
import com.fudex.ui.screens.myDirections.MyDirectionsScreen
import com.fudex.ui.screens.newDirection.NewDirectionScreen
import com.fudex.ui.screens.orderDetail.OrderDetailScreen
import com.fudex.ui.screens.paymentConfirm.PaymentConfirmScreen
import com.fudex.ui.screens.paymentMethod.PaymentMethodScreen
import com.fudex.ui.screens.productDetail.ProductDetailScreen
import com.fudex.ui.screens.products.ProductsScreen
import com.fudex.ui.screens.selectQuotes.SelectQuotesScreen
import com.fudex.ui.screens.tracking.TrackingScreen

fun NavGraphBuilder.clientNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "client_root",
        route = Destination.CLIENT_GRAPH.route
    ) {
        composable("client_root") {
            ClientBottomBarLayout(navController)
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


        //HOME
        composable(Destination.PRODUCTS.route) {
            ProductsScreen(
                navToProductDetail = { navController.navigate(Destination.PRODUCT_DETAIL.route) },
                navBack = {navController.popBackStack()},
            )
        }
        composable(Destination.PRODUCT_DETAIL.route) {
            ProductDetailScreen(
                navBack = {navController.popBackStack()},
            )
        }

        composable(Destination.CART.route) {
            CartScreen(
                navToMyDirections = { navController.navigate(Destination.MY_DIRECTIONS.route) },
                navBack = {navController.popBackStack()}
            )
        }
        composable(Destination.MY_DIRECTIONS.route) {
            MyDirectionsScreen(
                navToPaymentMethod = { navController.navigate(Destination.PAYMENT_METHOD.route) },
                navToNewDirection = { navController.navigate(Destination.NEW_DIRECTION.route) },
                navBack = {navController.popBackStack()}
            )
        }
        composable(Destination.PAYMENT_METHOD.route) {
            PaymentMethodScreen(
                navToSelectQuotes = { navController.navigate(Destination.SELECT_QUOTES.route) },
                navBack = {navController.popBackStack()}
            )
        }
        composable(Destination.SELECT_QUOTES.route) {
            SelectQuotesScreen(
                navToPaymentConfirm = { navController.navigate(Destination.PAYMENT_CONFIRM.route) },
                navBack = {navController.popBackStack()}
            )
        }
        composable(Destination.PAYMENT_CONFIRM.route) {
            PaymentConfirmScreen(
                navBackToHome = {
                    navController.navigate("client_root") {
                        popUpTo("client_root") { inclusive = false }
                        launchSingleTop = true
                    }
                }
            )
        }

        composable(Destination.NEW_DIRECTION.route) {
            NewDirectionScreen(
                navToDirectionMap = { navController.navigate(Destination.DIRECTION_MAP.route) },
                navBack = {navController.popBackStack()}
            )
        }
        composable(Destination.DIRECTION_MAP.route) {
            DirectionMapScreen(
                navBack = {navController.popBackStack(Destination.MY_DIRECTIONS.route, inclusive = false)}  // navegar dos veces hacia atras hasta MyDirections
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
