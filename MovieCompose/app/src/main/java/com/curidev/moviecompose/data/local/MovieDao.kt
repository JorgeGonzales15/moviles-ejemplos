package com.curidev.moviecompose.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.curidev.moviecompose.data.model.Movie

@Dao
interface MovieDao {

    @Insert
    fun insert(movie: Movie)

    @Delete
    fun delete(movie: Movie)

    @Query("select * from movies where id =:id ")//consulta sql
    fun fetchById(id: Int): Movie?


    @Query("select * from movies")
    fun fetchAll(): List<Movie>? // solo se trabaja con listas y cursores
}