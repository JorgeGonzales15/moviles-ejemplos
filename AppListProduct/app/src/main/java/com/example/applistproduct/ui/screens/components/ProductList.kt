package com.example.applistproduct.ui.screens.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.applistproduct.model.data.Product

@Composable
fun ProductList(products: MutableState<List<Product>>) {
    LazyColumn {
        items(products.value.size) { index ->
            ProductCard(products.value[index])
        }
    }
}