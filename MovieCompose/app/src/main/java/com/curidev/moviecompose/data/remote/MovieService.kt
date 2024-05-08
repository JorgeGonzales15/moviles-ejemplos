package com.curidev.moviecompose.data.remote

import com.curidev.moviecompose.data.model.MovieResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieService {

    @GET("{path}")
    fun getMovies(@Path("path")endpoint: String, //aqui es el endpoint depopular, mejores puntaciones y estreno es parte de la ruta
                  @Query("api_key") apiKey:String="3cae426b920b29ed2fb1c0749f258325"): Call<MovieResponse> //aqui se añade el apikey porque es un condicional


}