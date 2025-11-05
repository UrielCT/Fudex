package com.fudex.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


// 🔹 CompositionLocals para proveer las escalas
val LocalPaddingScale = compositionLocalOf { 1f }
val LocalFontScale = compositionLocalOf { 1f }

// 🔹 Extensiones simples para escalar Dp y Sp
fun Dp.scaled(scale: Float): Dp = (this.value * scale).dp
fun TextUnit.scaled(scale: Float): TextUnit = (this.value * scale).sp

// 🔹 Funciones @Composable para no pasar escala manualmente
@Composable
fun scaledPadding(base: Dp): Dp = base.scaled(LocalPaddingScale.current)

@Composable
fun scaledFont(base: TextUnit): TextUnit = base.scaled(LocalFontScale.current)




val CommonPaddingNone = 0.dp
val CommonPaddingOne = 1.dp
val CommonPaddingTwo = 2.dp
val CommonPaddingMicro = 4.dp
val CommonPaddingMicroMin = 6.dp
val CommonPaddingMin = 8.dp
val CommonPaddingTen = 10.dp
val CommonPaddingMinDefault = 12.dp
val CommonPaddingDefault = 16.dp
val CommonPaddingDefaultMid = 18.dp
val CommonPaddingMiddle = 24.dp
val CommonPaddingLarge = 32.dp
val CommonPaddingLarge_med = 48.dp
val CommonPaddingLarge_lm = 54.dp
val SnackBarPaddingBottom = 150.dp
//val CommonPaddingXLarge = 64.dp
//val CommonPaddingListItemVertical = 12.dp
val HomeBottomAppBarHeight = 60.dp
val BottomBarPadding = 64.dp

val PostImageHeight = 180.dp
val FilterImageSize = 80.dp

val DividerThickness = 0.8.dp

val MaxBubbleWidth = 280.dp


val AddPostSize = 40.dp
val GameBottomPadding = 100.dp
val DescriptionTextFieldHeight = 120.dp


val DropdownHeightInMax = 250.dp
val AlertDialogWidthInMax = 400.dp
val DropdownOffSetY = (-300).dp

val SmallScreenWidth = 360.dp
val MediumScreenWidth = 600.dp

val CommonFontSizeXXLarge = 24.sp
val CommonFontSizeXLarge = 22.sp
val CommonFontSizeLarge = 20.sp
val CommonFontSizeDefault = 18.sp
val CommonFontSizeDefaultMid = 17.sp
val CommonFontSizeMiddle = 16.sp
val CommonFontSizeMiddleMin = 15.sp
val CommonFontSizeMin = 14.sp
val CommonFontSizeMicro = 12.sp
val CommonFontSizeNano = 10.sp

val VersionDialogHeight = 300.dp
