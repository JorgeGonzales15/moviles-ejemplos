package com.example.estudiando.repositories

import android.util.Log
import com.example.estudiando.factories.PersonDaoFactory
import com.example.estudiando.model.data.Person
import com.example.estudiando.model.data.PersonResponse
import com.example.estudiando.factories.PersonServiceFactory
import com.example.estudiando.model.data.Id
import com.example.estudiando.model.data.Location
import com.example.estudiando.model.data.Name
import com.example.estudiando.model.data.Picture
import com.example.estudiando.model.local.PersonDao
import com.example.estudiando.model.local.PersonEntity
import com.example.estudiando.model.remote.PersonService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PersonRepository {
    private val personService: PersonService = PersonServiceFactory.getPersonService()
    private val personDao: PersonDao = PersonDaoFactory.getPersonDao()
    fun insertPerson(person: Person) {
        person.id.value?.let { id ->
            personDao.insert(
                PersonEntity(
                    id = id,
                    gender = person.gender,
                    title = person.name.title,
                    first = person.name.first,
                    city = person.location.city,
                    thumbnail = person.picture.thumbnail
                )
            )
        }
    }

    fun deletePerson(person: Person) {
        person.id.value?.let { id ->
            personDao.delete(PersonEntity(
                id = id,
                gender = person.gender,
                title = person.name.title,
                first = person.name.first,
                city = person.location.city,
                thumbnail = person.picture.thumbnail
            ))
        }
    }

    fun isFavorite(id: String): Boolean {
        return personDao.getById(id) != null
    }

    fun getPeople(nameOfPerson: String, callback: (List<Person>) -> Unit) {
        val call = personService.getPeople(nameOfPerson) // Modifica este método en tu servicio
        call.enqueue(object : Callback<PersonResponse> {
            override fun onResponse(
                call: Call<PersonResponse>,
                response: Response<PersonResponse>
            ) {
                if (response.isSuccessful) {
                    val people = response.body()?.results ?: emptyList()
                    if (people.isNotEmpty()) {
                        people.forEach { person ->
                            val idValue = person.id.value
                            if (idValue != null) {
                                person.isFavorite = isFavorite(idValue)
                            }
                        }
                    }
                    callback(people)
                } else {
                    Log.d("HeroRepository", "Error: ${response.errorBody()}")
                }
            }

            override fun onFailure(call: Call<PersonResponse>, t: Throwable) {
                t.message?.let {
                    Log.d("HeroRepository", it)
                }
            }
        })
    }

    fun getFavoritePeople(callback: (List<Person>) -> Unit) {
        val favoritePeople = personDao.getAll()
        callback(favoritePeople.map { personEntity ->
            Person(
                isFavorite = true,
                gender = personEntity.gender,
                name = Name(personEntity.title, personEntity.first, ""),
                email = "",
                cell = "",
                id = Id("", personEntity.id),
                picture = Picture("", "", personEntity.thumbnail),
                location = Location(personEntity.city)
            )
        })
    }


}