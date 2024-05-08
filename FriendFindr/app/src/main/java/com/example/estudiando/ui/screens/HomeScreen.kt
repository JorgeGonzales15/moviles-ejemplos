package com.example.estudiando.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.estudiando.ui.navigation.Routes
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun HomeScreen(navController: NavHostController) {
    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            GlideImage(
                imageModel = {"https://upload.wikimedia.org/wikipedia/en/8/88/Winston_Smith.jpg"},
                modifier = Modifier.size(200.dp)
            )
            HomeScreenButton(
                text = "Personas",
                onClick = { navController.navigate(Routes.People.route) }
            )
            HomeScreenButton(
                text = "Favoritos",
                onClick = { navController.navigate(Routes.Favorites.route) }
            )
        }
    }
}

@Composable
fun HomeScreenButton(
    text: String,
    onClick: () -> Unit
) {
    TextButton(
        colors = ButtonDefaults.buttonColors(
            containerColor = MaterialTheme.colorScheme.primary
        ),
        modifier = Modifier
            .padding(70.dp, 5.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Text(text)
    }
}