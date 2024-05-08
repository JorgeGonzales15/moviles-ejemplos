package com.curidev.moviecompose.ui.screens

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun Home(){

    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = Routes.WelcomeScreen.route) {

        composable(Routes.WelcomeScreen.route){
            WelcomeScreen(
                navigateToMovieListScreen = {navController.navigate(Routes.MovieListScreen.route)}
            )
        }

        composable(Routes.MovieListScreen.route){
            MovieListScreen()
        }

    }



}

sealed class Routes(val route: String) {
    data object WelcomeScreen : Routes("WelcomeScreen")
    data object MovieListScreen : Routes("MovieListScreen")



}