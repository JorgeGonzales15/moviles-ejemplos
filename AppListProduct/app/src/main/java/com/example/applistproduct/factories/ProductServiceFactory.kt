package com.example.applistproduct.factories

import com.example.applistproduct.model.remote.ProductService

class ProductServiceFactory private constructor() {
    companion object {
        private var productService: ProductService? = null

        fun getProductService(): ProductService {
            if (productService == null) {
                productService = RetrofitFactory.getRetrofit().create(ProductService::class.java)
            }
            return productService as ProductService
        }
    }
}