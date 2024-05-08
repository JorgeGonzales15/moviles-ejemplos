package com.curidev.moviecompose.data.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class MovieResponse(
    val results: List<Movie>
)

@Entity(tableName = "movies")
data class Movie (
    @PrimaryKey
    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String,


){

    constructor() : this (0,"","")

    @Ignore
    var isFavorite: Boolean = false
}


/*
antes de dao/favorites
data class MovieResponse(
    val results: List<Movie>
)

data class Movie (
    val id: Int,
    val title: String,
    @SerializedName("poster_path")
    val posterPath: String
)*/