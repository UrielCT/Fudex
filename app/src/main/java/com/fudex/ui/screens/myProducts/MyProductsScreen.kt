package com.fudex.ui.screens.myProducts

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.fudex.R

@Composable
fun MyProductsScreen(
    modifier: Modifier = Modifier,
    viewModel: MyProductsViewModel = hiltViewModel(),
    navToMyProductDetail:() -> Unit = {},
    navToAddProduct:() -> Unit = {},
) {
    val background = MaterialTheme.colorScheme.background
    val products = listOf(
        Product("Hamburguesa Clásica", 2500.0, R.drawable.hamburguesa),
        Product("Pizza Napolitana", 3500.0, R.drawable.hamburguesa),
        Product("Empanadas de Carne", 1200.0, R.drawable.hamburguesa),
        Product("Bebida Cola 500ml", 800.0, R.drawable.hamburguesa),
        Product("Helado Artesanal", 1500.0, R.drawable.hamburguesa),
        Product("Sandwich de Pollo", 2300.0, R.drawable.hamburguesa),
        Product("Sandwich de Pollo", 2300.0, R.drawable.hamburguesa),
        Product("Sandwich de Pollo", 2300.0, R.drawable.hamburguesa),
        Product("Sandwich de Pollo", 2300.0, R.drawable.hamburguesa),
        Product("Sandwich de Pollo", 2300.0, R.drawable.hamburguesa),
        Product("Sandwich de Pollo", 2300.0, R.drawable.hamburguesa),
    )

Box(modifier = modifier.fillMaxSize()){
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        modifier = Modifier.fillMaxSize().background(background),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(vertical = 40.dp, horizontal = 12.dp)
    ) {
        items(products) { product ->
            ProductCard(
                product = product,
                navToMyProductDetail = navToMyProductDetail
            )
        }
    }
}


}

data class Product(
    val name: String,
    val price: Double,
    val imageRes: Int
)

@Composable
fun ProductCard(
    product: Product,
    modifier: Modifier = Modifier,
    navToMyProductDetail:() -> Unit = {}
) {
    val surface = MaterialTheme.colorScheme.surface
    val onSurface = MaterialTheme.colorScheme.onSurface

    Card(
        modifier = modifier
            .fillMaxWidth()
            .height(220.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true)
            ) { navToMyProductDetail() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = surface)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Top
        ) {
            Image(
                painter = painterResource(id = product.imageRes),
                contentDescription = product.name,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(130.dp)
                    .clip(RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = product.name,
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = onSurface,
                    fontWeight = FontWeight.Medium
                ),
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )

            Text(
                text = "$${"%.2f".format(product.price)}",
                style = MaterialTheme.typography.bodyLarge.copy(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                ),
                modifier = Modifier.padding(vertical = 4.dp, horizontal = 8.dp)
            )
        }
    }
}
