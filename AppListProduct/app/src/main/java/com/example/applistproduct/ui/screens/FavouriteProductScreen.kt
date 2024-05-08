package com.example.applistproduct.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.applistproduct.factories.ProductRepositoryFactory
import com.example.applistproduct.model.data.Product
import com.example.applistproduct.ui.screens.components.ProductList

@Composable
fun FavouriteProductScreen() {
    val productRepository = ProductRepositoryFactory.getProductRepository()
    val products = remember { mutableStateOf(emptyList<Product>()) }

    productRepository.getFavoriteProducts { favouriteProducts ->
        products.value = favouriteProducts
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Favourite Products")
            ProductList(products = products)
        }

    }
}