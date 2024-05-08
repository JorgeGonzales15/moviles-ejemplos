package com.example.estudiando.model.data

data class PersonResponse(
    val results: List<Person>
)

data class Person(
    var isFavorite: Boolean? = false,

    val gender: String,
    val name: Name,
    val email: String,
    val cell: String,
    val id: Id,
    val picture: Picture,
    val location: Location
)

data class Location(
    val city: String,
)

data class Name(
    val title: String,
    val first: String,
    val last: String
)

data class Id(
    val name: String,
    val value: String
)

data class Picture(
    val large: String,
    val medium: String,
    val thumbnail: String
)
