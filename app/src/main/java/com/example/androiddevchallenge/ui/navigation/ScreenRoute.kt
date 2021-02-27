package com.example.androiddevchallenge.ui.navigation

sealed class ScreenRoute(
    val route: String
) {
    object DogsListScreen: ScreenRoute("dogsListScreen")
    object DogDetailScreen: ScreenRoute("dogDetailScreen")
}