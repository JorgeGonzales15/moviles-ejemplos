package com.example.applistproduct.repositories

import android.util.Log
import com.example.applistproduct.factories.ProductDaoFactory
import com.example.applistproduct.factories.ProductServiceFactory
import com.example.applistproduct.model.data.Product
import com.example.applistproduct.model.data.ProductResponse
import com.example.applistproduct.model.local.ProductEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductRepository {
    private val productService = ProductServiceFactory.getProductService()
    private val productDao = ProductDaoFactory.getProductDao()


    fun addFavorite(product: Product) {
        product.id?.let { id ->
            productDao.insert(
                ProductEntity(
                    id = id,
                    title = product.title,
                    image = product.image
                )
            )
        }
    }

    fun deleteFavorite(product: Product) {
        product.id?.let { id ->
            productDao.delete(
                ProductEntity(
                    id = id,
                    title = product.title,
                    image = product.image
                )
            )
        }
    }

    fun isFavorite(id: Int): Boolean {
        return productDao.getById(id) != null
    }

    fun getProducts(query: String, number: Int, callback: (List<Product>) -> Unit) {
        val call = productService.getProducts(query, number)
        call.enqueue(object : Callback<ProductResponse> {
            override fun onResponse(
                call: Call<ProductResponse>,
                response: Response<ProductResponse>
            ) {
                if (response.isSuccessful) {
                    val products = response.body()?.products ?: emptyList()
                    if (products.isNotEmpty()) {
                        products.forEach { product ->
                            product.isFavorite = isFavorite(product.id)
                        }
                    }

                    callback(products)
                } else {
                    Log.d("ProductRepository", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<ProductResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("ProductRepository", it)
                }
            }
        })
    }

    fun getFavoriteProducts(callback: (List<Product>) -> Unit) {
        val products = productDao.getAll().map {
            Product(id = it.id, title = it.title, image = it.image, isFavorite = true)
        }
        callback(products)
    }
}