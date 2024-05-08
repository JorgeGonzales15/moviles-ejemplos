package com.example.estudiando.factories

import com.example.estudiando.MyApplication
import com.example.estudiando.model.local.PersonDao
import com.example.estudiando.persistence.AppDatabase

class PersonDaoFactory private constructor() {
    companion object {
        private var personDao: PersonDao? = null
        fun getPersonDao(): PersonDao {
            if (personDao == null) {
                personDao = AppDatabase.getAppDatabase(MyApplication.getContext()).personDao()
            }
            return personDao as PersonDao
        }
    }
}