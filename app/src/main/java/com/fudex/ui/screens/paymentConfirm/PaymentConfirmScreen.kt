package com.fudex.ui.screens.paymentConfirm

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircleOutline
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PaymentConfirmScreen(
    modifier: Modifier = Modifier,
    viewModel: PaymentConfirmViewModel = hiltViewModel(),
    paymentMethod: String = "PayPal",
    amount: Double = 2500.0,
    onConfirm: () -> Unit = {},
    onCancel: () -> Unit = {},
    navBackToHome: () -> Unit = {},

) {
    val background = MaterialTheme.colorScheme.background
    val onBackground = MaterialTheme.colorScheme.onBackground
    val primary = MaterialTheme.colorScheme.primary
    val secondary = MaterialTheme.colorScheme.secondary

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .statusBarsPadding()
            .navigationBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))
        // Ícono de éxito
        Icon(
            imageVector = Icons.Default.CheckCircleOutline,
            contentDescription = "Pago exitoso",
            tint = primary,
            modifier = Modifier
                .size(140.dp)
                .padding(bottom = 32.dp)
        )

        // Título principal
        Text(
            text = "¡Pago realizado con éxito!",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = onBackground,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Subtítulo
        Text(
            text = "Hemos recibido tu pago de $${"%.2f".format(amount)} correctamente.",
            style = MaterialTheme.typography.bodyLarge.copy(
                color = onBackground.copy(alpha = 0.8f)
            ),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(horizontal = 32.dp)
        )

        //Spacer(modifier = Modifier.height(40.dp))
        Spacer(modifier = Modifier.weight(1f))

        // Botón continuar
        Button(
            onClick = { navBackToHome() },
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(0.8f)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = "Continuar",
                style = MaterialTheme.typography.bodyLarge.copy(
                    fontWeight = FontWeight.Bold
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Mensaje opcional de agradecimiento
        Text(
            text = "Gracias por tu compra 💙",
            style = MaterialTheme.typography.bodyMedium.copy(
                color = secondary,
                fontStyle = FontStyle.Italic
            ),
            textAlign = TextAlign.Center
        )
    }

}
