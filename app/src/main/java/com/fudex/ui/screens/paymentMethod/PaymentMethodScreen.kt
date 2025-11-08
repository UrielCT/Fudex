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
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PaymentMethodScreen(
    modifier: Modifier = Modifier,
    viewModel: PaymentMethodViewModel = hiltViewModel(),
    navToSelectQuotes: () -> Unit = {},
    navBack: () -> Unit = {},
    onSelectPayment: (String) -> Unit = {}
) {
    val backgroundColor = MaterialTheme.colorScheme.background
    val context = LocalContext.current

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .statusBarsPadding()
            .navigationBarsPadding(),
            //.padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.Center
    ) {

        TopAppBar(
            title = { Text("Payment Methods") },
            navigationIcon = {
                IconButton(onClick = { navBack() }) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Atrás")
                }
            },
            colors = TopAppBarDefaults.smallTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.surface,
                titleContentColor = MaterialTheme.colorScheme.onSurface
            )
        )

        Spacer(modifier = Modifier.weight(1f))

        PaymentOptionItem(
            imageRes = R.drawable.paypal,
            name = "PayPal",
            onClick = {
                navToSelectQuotes()
            //    onSelectPayment("PayPal")
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        PaymentOptionItem(
            imageRes = R.drawable.mercadopago,
            name = "Mercado Pago",
            onClick = {
                navToSelectQuotes()
                //onSelectPayment("MercadoPago")
            }
        )

        Spacer(modifier = Modifier.weight(1f))

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
                onClick()
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
