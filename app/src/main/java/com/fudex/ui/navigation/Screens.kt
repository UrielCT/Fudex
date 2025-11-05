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

}