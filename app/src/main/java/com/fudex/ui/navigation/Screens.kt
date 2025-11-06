package com.fudex.ui.navigation

import androidx.compose.ui.graphics.vector.ImageVector
import com.fudex.utils.Constants

enum class Destination(
    val route: String,
    val labelRes: Int? = null,
    val icon: ImageVector? = null,
    val contentDescription: String? = null
) {


    LOGIN(route = Constants.NAV_LOGIN),
    REGISTER(route = Constants.NAV_REGISTER),
    ROLES(route = Constants.NAV_ROLES),
    HOME(route = Constants.NAV_HOME),
    ORDERS(route = Constants.NAV_ORDERS),

    //ROLES

    AUTH_GRAPH(route = Constants.NAV_AUTH_GRAPH),
    CLIENT_GRAPH(route = Constants.NAV_CLIENT_GRAPH),
    RESTAURANT_GRAPH(route = Constants.NAV_RESTAURANT_GRAPH),
    DELIVERY_GRAPH(route = Constants.NAV_DELIVERY_GRAPH)

}