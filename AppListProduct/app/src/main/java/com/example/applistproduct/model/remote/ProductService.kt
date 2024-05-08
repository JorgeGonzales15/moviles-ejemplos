package com.example.applistproduct.model.remote

import com.example.applistproduct.model.data.ProductResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    @GET("search")
    fun getProducts(
        @Query("query") query: String,
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String = "979b107215934f4786cde0970b5cfe0a",
    ): Call<ProductResponse>
}