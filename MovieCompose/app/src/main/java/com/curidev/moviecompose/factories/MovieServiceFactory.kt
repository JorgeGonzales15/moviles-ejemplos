package com.curidev.moviecompose.factories

import com.curidev.moviecompose.data.remote.MovieService
import com.curidev.moviecompose.network.ApiClient
import retrofit2.create

object MovieServiceFactory {

    fun getMovieService(): MovieService{
        return ApiClient.getRetrofit().create(MovieService::class.java)
    }
}