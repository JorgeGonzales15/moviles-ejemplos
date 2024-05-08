package com.example.estudiando.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.estudiando.model.local.PersonDao
import com.example.estudiando.model.local.PersonEntity

@Database(entities = [PersonEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun personDao(): PersonDao

    companion object {
        private var appDatabase: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase =
                    Room.databaseBuilder(context, AppDatabase::class.java, "friend_findr-db")
                        .allowMainThreadQueries().build()
            }
            return appDatabase as AppDatabase
        }
    }
}