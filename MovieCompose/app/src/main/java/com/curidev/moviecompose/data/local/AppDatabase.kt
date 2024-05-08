package com.curidev.moviecompose.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.curidev.moviecompose.data.model.Movie

@Database(entities = [Movie::class], version = 1)
abstract class AppDatabase:RoomDatabase() {


    abstract fun getMovieDao(): MovieDao

    companion object {
        var appDatabase : AppDatabase? = null

        fun getInstance(context: Context): AppDatabase{
            if (appDatabase==null){

                appDatabase = Room.databaseBuilder(context, AppDatabase::class.java, name = "db").allowMainThreadQueries().build()


            }
            return appDatabase as AppDatabase
        }

    }
}