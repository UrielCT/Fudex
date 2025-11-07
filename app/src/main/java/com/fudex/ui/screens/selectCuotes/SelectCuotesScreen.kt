package com.fudex.ui.screens.selectCuotes

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SelectCuotesScreen(
    modifier: Modifier = Modifier,
    viewModel: SelectCuotesViewModel = hiltViewModel(),
    onConfirm: () -> Unit = {},
    onCancel: () -> Unit = {}
){

    val background = MaterialTheme.colorScheme.background
    val onBackground = MaterialTheme.colorScheme.onBackground
    val primary = MaterialTheme.colorScheme.primary
    val secondary = MaterialTheme.colorScheme.secondary
    val surface = MaterialTheme.colorScheme.surface

    val cuotas = listOf(1, 3, 6, 9, 12)
    var selectedCuota by remember { mutableStateOf(cuotas.first()) }
    val total = 1000.0
    val cuotaValue = total / selectedCuota

    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(background)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Título
        Text(
            text = "Seleccione las cuotas",
            style = MaterialTheme.typography.headlineSmall.copy(
                color = onBackground,
                fontWeight = FontWeight.Bold
            ),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Campo desplegable
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded },
            modifier = Modifier
                .fillMaxWidth(0.8f)
        ) {
            OutlinedTextField(
                value = "$selectedCuota cuotas",
                onValueChange = {},
                readOnly = true,
                label = { Text("Cantidad de cuotas") },
                trailingIcon = {
                    ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded)
                },
                colors = ExposedDropdownMenuDefaults.textFieldColors(
                    focusedTextColor = onBackground,
                    unfocusedTextColor = onBackground,
                    focusedContainerColor = surface,
                    unfocusedContainerColor = surface,
                    focusedIndicatorColor = primary,
                    unfocusedIndicatorColor = secondary.copy(alpha = 0.5f)
                ),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                //containerColor = surface
            ) {
                cuotas.forEach { cuota ->
                    DropdownMenuItem(
                        text = { Text("$cuota cuotas") },
                        onClick = {
                            selectedCuota = cuota
                            expanded = false
                        },
                        contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }

        //Spacer(modifier = Modifier.height(40.dp))
        Spacer(modifier = Modifier.weight(1f))



        // Resumen del pago
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {

            Text(
                text = "Total: $${"%.2f".format(total)}",
                style = MaterialTheme.typography.titleMedium.copy(
                    color = onBackground,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "$selectedCuota cuota${if (selectedCuota > 1) "s" else ""} de $${"%.2f".format(cuotaValue)}",
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = onBackground.copy(alpha = 0.8f)
                )
            )
        }

        Spacer(modifier = Modifier.height(40.dp))

        // Botón principal
        Button(
            onClick = onConfirm,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = primary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            )
        ) {
            Text(
                text = "Confirmar pago",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botón secundario
        OutlinedButton(
            onClick = onCancel,
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            border = BorderStroke(1.dp, secondary),
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = secondary
            )
        ) {
            Text(
                text = "Cancelar",
                style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Medium)
            )
        }
    }

}