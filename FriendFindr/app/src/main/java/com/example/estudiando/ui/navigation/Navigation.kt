package com.example.estudiando.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.estudiando.ui.screens.FavoritesScreen
import com.example.estudiando.ui.screens.HomeScreen
import com.example.estudiando.ui.screens.PeopleScreen

@Composable
fun Navigation() {
    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
        composable(Routes.Favorites.route) {
            FavoritesScreen()
        }
        composable(Routes.People.route) {
            PeopleScreen()
        }
    }
}

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object People : Routes("people")
    data object Favorites : Routes("favorites")
}