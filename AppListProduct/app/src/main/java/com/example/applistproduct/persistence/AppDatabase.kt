package com.example.applistproduct.persistence

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.applistproduct.model.local.ProductDao
import com.example.applistproduct.model.local.ProductEntity

@Database(entities = [ProductEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao

    companion object {
        private var appDatabase: AppDatabase? = null
        fun getAppDatabase(context: Context): AppDatabase {
            if (appDatabase == null) {
                appDatabase =
                    Room.databaseBuilder(context, AppDatabase::class.java, "product-db")
                        .allowMainThreadQueries().build()
            }
            return appDatabase as AppDatabase
        }
    }
}