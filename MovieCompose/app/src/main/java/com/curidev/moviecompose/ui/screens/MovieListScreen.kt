package com.curidev.moviecompose.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Card
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.bumptech.glide.Glide
import com.curidev.moviecompose.data.model.Movie
import com.curidev.moviecompose.network.ApiClient
import com.curidev.moviecompose.repositories.MovieRepository
import com.curidev.moviecompose.shared.ui.CustomButton
import com.skydoves.landscapist.glide.GlideImage

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(movieRepository: MovieRepository = MovieRepository()){
    
    Scaffold {
        paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally){
            
            val endpoints = listOf("popular", "top_rated", "upcoming") //estados para las peliculas com oarreglo
            val expanded = remember { //estado para el menu de despliegue, por defecto no expandido
                mutableStateOf(false)
            }

            val movies = remember{ //estado para getear pleiculas
                mutableStateOf(emptyList<Movie>())
            }

            val selectedEndpoint = remember {//estado seleccionado de pelicula

            mutableStateOf(endpoints[0]) // pordefecto 0 en el arreglo

            }

            ExposedDropdownMenuBox(expanded = expanded.value, onExpandedChange = {expanded.value = !expanded.value}) {

            //se pasa el value de la variable  y luego se cambia el valor a su estado contrario

                Box{
                    OutlinedTextField(value = selectedEndpoint.value,
                        onValueChange = {}, //si no funciona ver 26:51
                        readOnly = true, // deesta manera no se edita la caja de texto
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded.value)},
                        modifier = Modifier.menuAnchor()
                    )
                    ExposedDropdownMenu(expanded = expanded.value, onDismissRequest = {expanded.value=false}) { //ondismiss es para cuando se de un click se cierre el menu

                        endpoints.forEach{
                            DropdownMenuItem(text = { Text(it)}, onClick = {

                                selectedEndpoint.value=it
                                expanded.value = false

                            })
                        }

                        
                    }
                    
                }

            }

            CustomButton(text = "Show", onclick = {
                MovieRepository().getMovies(selectedEndpoint.value){
                    movies.value = it

                }
            })

            LazyColumn {
                items(movies.value){
                    MovieItem(it)
                }
            }
            
        }
    }

}

@Composable
fun MovieItem(movie: Movie){


    val isFavorite = remember {
        mutableStateOf(movie.isFavorite)
    }

    Card (modifier = Modifier.padding(4.dp)){
        Row(modifier = Modifier.fillMaxWidth()){
            MovieImage(movie.posterPath)
            Text(modifier = Modifier.weight(3f),text = movie.title)
            IconButton(modifier = Modifier.weight(1f), onClick = { isFavorite.value = !isFavorite.value
            movie.isFavorite = isFavorite.value}) {
                Icon(Icons.Filled.Favorite, "Favorite",
                    tint = if(isFavorite.value){
                        MaterialTheme.colorScheme.primary
                    }else{
                        Color.Gray
                    }

                )

            }
        }

    }
}

@Composable
fun MovieImage(posterPath: String) {



    GlideImage(imageModel = {ApiClient.getImage(posterPath)}, modifier = Modifier.size(92.dp))

}
