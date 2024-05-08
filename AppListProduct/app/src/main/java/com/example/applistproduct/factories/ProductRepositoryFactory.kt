package com.example.applistproduct.factories

import com.example.applistproduct.repositories.ProductRepository

class ProductRepositoryFactory private constructor() {
    companion object {
        private var productRepository: ProductRepository? = null

        fun getProductRepository(): ProductRepository {
            if (productRepository == null) {
                productRepository = ProductRepository()
            }
            return productRepository as ProductRepository
        }
    }
}