package com.example.estudiando.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.estudiando.model.data.Person
import com.example.estudiando.factories.PersonRepositoryFactory
import com.example.estudiando.ui.screens.components.PeopleList


@Composable
fun PeopleScreen() {
    val personName = remember { mutableStateOf("") }
    val people = remember { mutableStateOf(emptyList<Person>()) }

    val personRepository = PersonRepositoryFactory.getPersonRepository()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Personas",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.primary,
                fontWeight = FontWeight.Bold
            )
            SearchBar(personName) {
                personRepository.getPeople(personName.value) { response ->
                    people.value = response
                }
            }
            PeopleList(people)
        }
    }
}

@Composable
fun SearchBar(personName: MutableState<String>, onShowPeopleClick: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = personName.value,
            onValueChange = {
                personName.value = it
            },
            placeholder = {
                Text(text = "Enter person's name")
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .weight(1f)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Button(
            onClick = onShowPeopleClick,
            modifier = Modifier
                .padding(start = 16.dp)
        ) {
            Text("Search")
        }
    }
}
