package com.curidev.moviecompose.factories

import com.curidev.moviecompose.MyApplication
import com.curidev.moviecompose.data.local.AppDatabase
import com.curidev.moviecompose.data.local.MovieDao

object MovieDaoFactory {

    fun getDao() : MovieDao{
        return AppDatabase.getInstance(MyApplication.getContext()).getMovieDao()
    }

}