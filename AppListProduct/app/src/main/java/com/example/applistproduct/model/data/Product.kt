package com.example.applistproduct.model.data

data class ProductResponse(
    val products: List<Product>
)

data class Product(
    var isFavorite: Boolean? = false,

    val id: Int,
    val title: String,
    val image: String,
)
