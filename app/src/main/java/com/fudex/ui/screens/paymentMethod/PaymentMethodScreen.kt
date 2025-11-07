package com.fudex.ui.screens.paymentMethod

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fudex.R
import com.fudex.ui.screens.roles.RoleCard
import kotlinx.coroutines.delay

@Composable
fun PaymentMethodScreen(
    modifier: Modifier = Modifier,
    viewModel: PaymentMethodViewModel = hiltViewModel(),
    onSelectPayment: (String) -> Unit = {}
) {
    val backgroundColor = MaterialTheme.colorScheme.background
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        PaymentOptionItem(
            imageRes = R.drawable.paypal,
            name = "PayPal",
            onClick = { onSelectPayment("PayPal") }
        )

        Spacer(modifier = Modifier.height(32.dp))

        PaymentOptionItem(
            imageRes = R.drawable.mercadopago,
            name = "Mercado Pago",
            onClick = { onSelectPayment("MercadoPago") }
        )
    }
}

@Composable
fun PaymentOptionItem(
    @DrawableRes imageRes: Int,
    name: String,
    onClick: () -> Unit
) {
    val interactionSource = remember { MutableInteractionSource() }
    var pressed by remember { mutableStateOf(false) }

    // Efecto de escala al presionar
    val scale by animateFloatAsState(
        targetValue = if (pressed) 0.95f else 1f,
        label = "scaleAnimation"
    )

    Image(
        painter = painterResource(id = imageRes),
        contentDescription = name,
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(160.dp)
            .graphicsLayer(scaleX = scale, scaleY = scale)
            .clip(RoundedCornerShape(16.dp))
            .background(MaterialTheme.colorScheme.surface)
            .clickable(
                interactionSource = interactionSource,
                indication = rememberRipple(color = MaterialTheme.colorScheme.primary)
            ) {
//                pressed = true
//                onClick()
//
//                LaunchedEffect(Unit) {
//                    delay(100)
//                    pressed = false
//                }
            }
            .padding(16.dp)
    )
}
