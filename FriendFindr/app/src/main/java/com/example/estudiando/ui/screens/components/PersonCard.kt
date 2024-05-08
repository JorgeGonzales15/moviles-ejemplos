package com.example.estudiando.ui.screens.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.estudiando.factories.PersonRepositoryFactory
import com.example.estudiando.model.data.Person
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PersonCard(person: Person, showAdditionalInfo: Boolean = false) {
    val isFavorite = remember {
        mutableStateOf(person.isFavorite)
    }

    val personRepository = PersonRepositoryFactory.getPersonRepository()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Row(modifier = Modifier.padding(8.dp)) {
            GlideImage(
                imageModel = { person.picture.thumbnail },
                modifier = Modifier.size(100.dp)
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(18.dp, 0.dp)
            ) {
                if (showAdditionalInfo) {
                    Text(text = "Title: ${person.name.title}")
                    Text(text = "Name: ${person.name.first}")
                    Text(text = "Gender: ${person.gender}")
                    Text(text = "City: ${person.location.city}")
                }
                else {
                    Text(text = "Name: ${person.name.first} ${person.name.last}")
                    Text(text = "Email: ${person.email}")
                    Text(text = "Phone number: ${person.cell}")
                }
            }
            IconButton(onClick = {
                isFavorite.value = isFavorite.value?.not() ?: false
                if (isFavorite.value == true) {
                    personRepository.insertPerson(person)
                    person.isFavorite = true
                } else {
                    personRepository.deletePerson(person)
                    person.isFavorite = false
                }

                person.isFavorite = isFavorite.value
            }) {
                Icon(
                    Icons.Filled.Favorite, "Favorite", tint = if (isFavorite.value == true) {
                        MaterialTheme.colorScheme.primary
                    } else {
                        Color.Gray
                    }
                )
            }
        }
    }
}
