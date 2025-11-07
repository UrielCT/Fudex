package com.fudex.ui.screens.myProductDetail

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.fudex.R
import com.fudex.ui.components.AutoSlidingCarousel
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun MyProductDetailScreen(
    modifier: Modifier = Modifier,
    viewModel: MyProductDetailViewModel = hiltViewModel(),
    productName: String = "Hamburguesa Clásica",
    productDescription: String = "Deliciosa hamburguesa con carne 100% vacuna, queso cheddar, lechuga, tomate y pan artesanal.",
    productPrice: Double = 2500.0,
    images: List<Int> = listOf(
        R.drawable.hamburguesa,
        R.drawable.hamburguesa,
        R.drawable.hamburguesa),
    navBack: () -> Unit = {}
) {
    val context = LocalContext.current

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val screenWidth = maxWidth
        val coverHeight = screenWidth * 0.55f

        ConstraintLayout(modifier = Modifier.fillMaxSize()) {
            val (coverImg, content, btnBack, btnEdit) = createRefs()


            AutoSlidingCarousel(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(coverHeight)
                    .constrainAs(coverImg) {
                        top.linkTo(parent.top)
                    },
                itemsCount = images.size
            ) { page ->
                Image(
                    painter = painterResource(id = images[page]),
                    contentDescription = "Imagen ${page + 1}",
                    modifier = Modifier.fillMaxSize(),
                    contentScale = ContentScale.Crop
                )
            }

            IconButton(
                onClick = {  },
                modifier = Modifier
                    .constrainAs(btnBack) {
                        top.linkTo(parent.top, 16.dp)
                        start.linkTo(parent.start, 16.dp)
                    }

                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }


            IconButton(
                onClick = {  },
                modifier = Modifier
                    .constrainAs(btnEdit) {
                        top.linkTo(parent.top, 16.dp)
                        end.linkTo(parent.end, 16.dp)
                    }

                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.3f),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.Default.Edit,
                    contentDescription = null,
                    tint = MaterialTheme.colorScheme.onPrimary
                )
            }



            IconButton(
                onClick = navBack,
                modifier = Modifier
                    .constrainAs(btnBack) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .padding(16.dp)
                    .background(
                        color = MaterialTheme.colorScheme.surface.copy(alpha = 0.7f),
                        shape = CircleShape
                    )
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Volver",
                    tint = MaterialTheme.colorScheme.onSurface
                )
            }


            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .constrainAs(content) {
                        top.linkTo(coverImg.bottom)
                        bottom.linkTo(parent.bottom)
                        height = Dimension.fillToConstraints
                    },
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                item {
                    Spacer(modifier = Modifier.height(16.dp))

                    Text(
                        text = productName,
                        style = MaterialTheme.typography.headlineSmall.copy(
                            fontWeight = FontWeight.Bold,
                            color = MaterialTheme.colorScheme.onBackground
                        )
                    )


                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = "$ $productPrice",
                        style = MaterialTheme.typography.titleMedium.copy(
                            color = MaterialTheme.colorScheme.primary,
                            fontWeight = FontWeight.Bold
                        )
                    )

                    Spacer(modifier = Modifier.height(8.dp))

                    Text(
                        text = productDescription,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            color = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f)
                        )
                    )

                }

            }

        }
    }
}
