package com.example.estudiando.model.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "people")
data class PersonEntity(
    @PrimaryKey val id: String,
    val gender: String,
    val title: String,
    val first: String,
    val city: String,
    val thumbnail: String,
)