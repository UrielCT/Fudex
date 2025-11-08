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
    //CLIENT_ROOT(route = Constants.NAV_CLIENT_ROOT),
    RESTAURANT_GRAPH(route = Constants.NAV_RESTAURANT_GRAPH),
    DELIVERY_GRAPH(route = Constants.NAV_DELIVERY_GRAPH),

    //Secondary screens
    ORDER_DETAIL(route = Constants.NAV_ORDER_DETAIL),
    TRACKING(route = Constants.NAV_TRACKING),
    CART(route = Constants.NAV_CART),
    MY_DIRECTIONS(route = Constants.NAV_MY_DIRECTIONS),
    NEW_DIRECTION(route = Constants.NAV_NEW_DIRECTION),
    DIRECTION_MAP(route = Constants.NAV_DIRECTION_MAP),
    PAYMENT_METHOD(route = Constants.NAV_PAYMENT_METHOD),
    SELECT_QUOTES(route = Constants.NAV_SELECT_QUOTES),
    PAYMENT_CONFIRM(route = Constants.NAV_PAYMENT_CONFIRM),

    PRODUCTS(route = Constants.NAV_PRODUCTS),
    PRODUCT_DETAIL(route = Constants.NAV_PRODUCT_DETAIL),

    EDIT_PROFILE(route = Constants.NAV_EDIT_PROFILE),


    ADD_EDIT_CATEGORIES(route = Constants.NAV_ADD_EDIT_CATEGORIES),
    ADD_EDIT_PRODUCT(route = Constants.NAV_ADD_EDIT_PRODUCT),
    MY_PRODUCT_DETAIL(route = Constants.NAV_MY_PRODUCT_DETAIL),



}