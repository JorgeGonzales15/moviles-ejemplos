package com.curidev.moviecompose.repositories

import android.util.Log
import com.curidev.moviecompose.data.local.MovieDao
import com.curidev.moviecompose.data.model.Movie
import com.curidev.moviecompose.data.model.MovieResponse
import com.curidev.moviecompose.data.remote.MovieService
import com.curidev.moviecompose.factories.MovieDaoFactory
import com.curidev.moviecompose.factories.MovieServiceFactory
import com.curidev.moviecompose.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository (private val movieService: MovieService=MovieServiceFactory.getMovieService(),
    private val movieDao: MovieDao = MovieDaoFactory.getDao()){

    fun insert(movie: Movie){

        movieDao.insert(movie)

    }

    fun delete(movie: Movie){

        movieDao.delete(movie)

    }

    fun isFavorite(id: Int): Boolean{
        return (movieDao.fetchById(id)!=null)
    }

    fun getMovies(endpoint: String, callback: (List<Movie>) -> Unit){

        val getMovies = movieService.getMovies(endpoint)

        getMovies.enqueue(object: Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful){
                    val movies = response.body()?.results?: emptyList()
                    movies.forEach(){
                        it.isFavorite = isFavorite(it.id)
                    }
                    callback (movies)
                }
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("MovieRepository", it)
                }
            }
        })

    }












}