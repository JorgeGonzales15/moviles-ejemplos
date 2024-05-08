package com.curidev.moviecompose.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    private const val BASE_URL = "https://api.themoviedb.org/3/movie/"
    private const val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500" //NO VA SLASH POR QUE EN EL API YA VIENE

    fun getRetrofit(): Retrofit{
        return Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }

    fun getImage(url:String) : String{
        return "${ApiClient.IMAGE_BASE_URL}$url"
    }
}