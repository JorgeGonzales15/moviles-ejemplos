package com.example.estudiando.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.estudiando.factories.PersonRepositoryFactory
import com.example.estudiando.model.data.Person
import com.example.estudiando.ui.screens.components.PeopleList

@Composable
fun FavoritesScreen() {
    val people = remember { mutableStateOf(emptyList<Person>()) }

    val personRepository = PersonRepositoryFactory.getPersonRepository()

    personRepository.getFavoritePeople { favoritePeople ->
        people.value = favoritePeople
    }

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Favoritos",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            PeopleList(people = people, showAdditionalInfo = true)
        }
    }
}

