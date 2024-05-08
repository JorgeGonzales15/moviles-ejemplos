package com.example.estudiando.factories

import com.example.estudiando.repositories.PersonRepository

class PersonRepositoryFactory private constructor() {
    companion object {
        private var personRepository: PersonRepository? = null

        fun getPersonRepository(): PersonRepository {
            if (personRepository == null) {
                personRepository = PersonRepository()
            }
            return personRepository as PersonRepository
        }
    }
}