package com.example.estudiando.ui.screens.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import com.example.estudiando.model.data.Person

@Composable
fun PeopleList(people: MutableState<List<Person>>, showAdditionalInfo: Boolean = false) {
    LazyColumn {
        items(people.value.size) { index ->
            PersonCard(person = people.value[index], showAdditionalInfo = showAdditionalInfo)
        }
    }
}

