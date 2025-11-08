package com.fudex.ui.navigation

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun RoleBottomBar(
    items: List<BottomNavItem>,
    navController: NavHostController
) {
    val currentDestination = navController.currentBackStackEntryAsState().value?.destination?.route
    var lastClickTime by remember { mutableStateOf(0L) }

    NavigationBar {
        items.forEach { item ->
            val selected = currentDestination == item.route
            val iconAlpha by animateFloatAsState(if (selected) 1f else 0.5f, label = "")

            NavigationBarItem(
                selected = selected,
                onClick = {
                    val currentTime = System.currentTimeMillis()
                    if (currentTime - lastClickTime < 500) return@NavigationBarItem
                    lastClickTime = currentTime

                    navController.navigate(item.route) {
                        popUpTo(0){inclusive =true}
                        //popUpTo(navController.graph.startDestinationId) { saveState = true }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                icon = {
                    Icon(
                        item.icon,
                        contentDescription = item.label,
                        modifier = Modifier.alpha(iconAlpha)
                    )
                },
                label = { Text(item.label) }
            )
        }
    }
}
