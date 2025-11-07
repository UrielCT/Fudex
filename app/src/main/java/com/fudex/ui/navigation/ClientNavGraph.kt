package com.fudex.ui.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.fudex.ui.components.AppScaffold
import com.fudex.ui.screens.home.HomeScreen
import com.fudex.ui.screens.paymentMethod.PaymentMethodScreen

fun NavGraphBuilder.clientNavGraph(navController: NavHostController) {
    navigation(
        startDestination = "client_home",
        route = Destination.CLIENT_GRAPH.route
    ) {

        composable("client_home"){
            //HomeScreen("Client Home")
            PaymentMethodScreen()
        }



//        composable("client_home") {
//            AppScaffold(
//                topBar = { TopBarSimple(title = "Home") },
//                bottomBar = { ClientBottomBar(navController) }
//            ) {
//                HomeScreen()
//            }
//        }
//        composable("products") { ProductsScreen() }
//        composable("product_detail") { ProductDetailScreen() }
//        composable("cart") { CartScreen() }
//        composable("orders") { OrdersScreen() }
//        composable("order_detail") { OrderDetailScreen() }
//        composable("tracking") { TrackingScreen() }
//        composable("my_directions") { MyDirectionScreen() }
//        composable("new_direction") { NewDirectionScreen() }
//        composable("direction_map") { DirectionMapScreen() }
//        composable("payment_method") { PaymentMethodScreen() }
//        composable("select_cuotes") { SelectCuotesScreen() }
//        composable("payment_confirm") { PaymentConfirmScreen() }
//        composable("profile") { ProfileScreen() }
//        composable("edit_profile") { EditProfileScreen() }
    }
}
