package com.example.applistproduct.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert
    fun insert(productEntity: ProductEntity)

    @Delete
    fun delete(productEntity: ProductEntity)

    @Query("SELECT * FROM products")
    fun getAll(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getById(id: Int): ProductEntity
}