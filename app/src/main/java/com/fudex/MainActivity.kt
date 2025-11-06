package com.fudex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Constraints
import androidx.navigation.compose.rememberNavController
import com.fudex.ui.navigation.Destination
import com.fudex.ui.navigation.MainNavGraph
import com.fudex.ui.screens.login.LoginScreen
import com.fudex.ui.screens.register.RegisterScreen
import com.fudex.ui.screens.roles.RolesScreen
import com.fudex.ui.theme.FudexTheme
import com.fudex.ui.theme.LocalFontScale
import com.fudex.ui.theme.LocalPaddingScale
import com.fudex.utils.Constants
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("ConfigurationScreenWidthHeight")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FudexTheme {
                val navController = rememberNavController()
                val startDestination = Destination.AUTH_GRAPH.route  //"auth_graph"

                val configuration = LocalConfiguration.current
                val screenWidth = configuration.screenWidthDp
                val screenHeight = configuration.screenHeightDp

                // Escalas adaptativas
                val fontScale = screenWidth / 411f
                val paddingScale = screenHeight / 891f

                CompositionLocalProvider(
                    LocalPaddingScale provides paddingScale,
                    LocalFontScale provides fontScale
                ) {
                    MainNavGraph(
                        navController = navController,
                        startDestination = startDestination
                    )

//                    LoginScreen(
//                        navToHome = {},
//                        navToRegister = {}
//                    )
//                    RegisterScreen (
//                        navToHome = {},
//                        navToLogin = {}
//                    )
//                    RolesScreen (
//                        navToOrders = {}
//                    )
                    //NavigationBarScreen()
                }
            }
        }
    }
}

