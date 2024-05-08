package com.example.applistproduct.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.applistproduct.ui.screens.FavouriteProductScreen
import com.example.applistproduct.ui.screens.FindProductScreen
import com.example.applistproduct.ui.screens.HomeScreen

@Composable
fun Navigation() {
    val navController = rememberNavController();

    NavHost(navController = navController, startDestination = Routes.Home.route) {
        composable(Routes.Home.route) {
            HomeScreen(navController)
        }
        composable(Routes.Favorites.route) {
            FavouriteProductScreen()
        }
        composable(Routes.Product.route) {
            FindProductScreen()
        }
    }
}

sealed class Routes(val route: String) {
    data object Home : Routes("home")
    data object Product : Routes("product")
    data object Favorites : Routes("favourites")
}