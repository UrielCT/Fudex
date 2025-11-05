package com.fudex

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalConfiguration
import com.fudex.ui.screens.login.LoginScreen
import com.fudex.ui.screens.register.RegisterScreen
import com.fudex.ui.theme.FudexTheme
import com.fudex.ui.theme.LocalFontScale
import com.fudex.ui.theme.LocalPaddingScale
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("ConfigurationScreenWidthHeight")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FudexTheme {
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
//                    LoginScreen(
//                        navToHome = {},
//                        navToRegister = {}
//                    )
                    RegisterScreen (
                        navToHome = {},
                        navToLogin = {}
                    )
                    //NavigationBarScreen()
                }
            }
        }
    }
}

