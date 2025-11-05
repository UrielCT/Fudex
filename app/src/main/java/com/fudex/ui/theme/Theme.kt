package com.fudex.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

//private val DarkColorScheme = darkColorScheme(
//    primary = Purple80,
//    secondary = PurpleGrey80,
//    tertiary = Pink80
//)
//
//private val LightColorScheme = lightColorScheme(
//    primary = Purple40,
//    secondary = PurpleGrey40,
//    tertiary = Pink40
//
//    /* Other default colors to override
//    background = Color(0xFFFFFBFE),
//    surface = Color(0xFFFFFBFE),
//    onPrimary = Color.White,
//    onSecondary = Color.White,
//    onTertiary = Color.White,
//    onBackground = Color(0xFF1C1B1F),
//    onSurface = Color(0xFF1C1B1F),
//    */
//)


private val PremiumLightColorScheme = lightColorScheme(
    primary = PremiumPrimaryLight,
    onPrimary = PremiumOnPrimaryLight,
    secondary = PremiumSecondaryLight,
    onSecondary = PremiumOnSecondaryLight,
    background = PremiumBackgroundLight,
    onBackground = PremiumOnBackgroundLight,
    surface = PremiumSurfaceLight,
    onSurface = PremiumOnSurfaceLight,
)

private val PremiumDarkColorScheme = darkColorScheme(
    primary = PremiumPrimaryDark,
    onPrimary = PremiumOnPrimaryDark,
    secondary = PremiumSecondaryDark,
    onSecondary = PremiumOnSecondaryDark,
    background = PremiumBackgroundDark,
    onBackground = PremiumOnBackgroundDark,
    surface = PremiumSurfaceDark,
    onSurface = PremiumOnSurfaceDark,
)

//
//private val NaturalLightColorScheme = lightColorScheme(
//    primary = NaturalPrimaryLight,
//    onPrimary = NaturalOnPrimaryLight,
//    secondary = NaturalSecondaryLight,
//    onSecondary = NaturalOnSecondaryLight,
//    background = NaturalBackgroundLight,
//    onBackground = NaturalOnBackgroundLight,
//    surface = NaturalSurfaceLight,
//    onSurface = NaturalOnSurfaceLight,
//)
//
//private val NaturalDarkColorScheme = darkColorScheme(
//    primary = NaturalPrimaryDark,
//    onPrimary = NaturalOnPrimaryDark,
//    secondary = NaturalSecondaryDark,
//    onSecondary = NaturalOnSecondaryDark,
//    background = NaturalBackgroundDark,
//    onBackground = NaturalOnBackgroundDark,
//    surface = NaturalSurfaceDark,
//    onSurface = NaturalOnSurfaceDark,
//)
//
//
//
//private val ModernLightColorScheme = lightColorScheme(
//    primary = ModernPrimaryLight,
//    onPrimary = ModernOnPrimaryLight,
//    secondary = ModernSecondaryLight,
//    onSecondary = ModernOnSecondaryLight,
//    background = ModernBackgroundLight,
//    onBackground = ModernOnBackgroundLight,
//    surface = ModernSurfaceLight,
//    onSurface = ModernOnSurfaceLight,
//)
//
//private val ModernDarkColorScheme = darkColorScheme(
//    primary = ModernPrimaryDark,
//    onPrimary = ModernOnPrimaryDark,
//    secondary = ModernSecondaryDark,
//    onSecondary = ModernOnSecondaryDark,
//    background = ModernBackgroundDark,
//    onBackground = ModernOnBackgroundDark,
//    surface = ModernSurfaceDark,
//    onSurface = ModernOnSurfaceDark,
//)
//
//
//
//
//
//private val LightColorScheme = lightColorScheme(
//    primary = PrimaryLight,
//    onPrimary = OnPrimaryLight,
//    secondary = SecondaryLight,
//    onSecondary = OnSecondaryLight,
//    background = BackgroundLight,
//    onBackground = OnBackgroundLight,
//    surface = SurfaceLight,
//    onSurface = OnSurfaceLight,
//
//)
//
//private val DarkColorScheme = darkColorScheme(
//    primary = PrimaryDark,
//    onPrimary = OnPrimaryDark,
//    secondary = SecondaryDark,
//    onSecondary = OnSecondaryDark,
//    background = BackgroundDark,
//    onBackground = OnBackgroundDark,
//    surface = SurfaceDark,
//    onSurface = OnSurfaceDark,
//)

@Composable
fun FudexTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme

        darkTheme -> PremiumDarkColorScheme
        else -> PremiumLightColorScheme
//
//        darkTheme -> NaturalDarkColorScheme
//        else -> NaturalLightColorScheme
//
//        darkTheme -> ModernDarkColorScheme
//        else -> ModernLightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}