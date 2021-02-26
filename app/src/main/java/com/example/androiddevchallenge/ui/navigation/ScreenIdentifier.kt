package com.example.androiddevchallenge.ui.navigation

sealed class ScreenIdentifier(
    val route: String
) {
    object DogsListScreen: ScreenIdentifier("dogsListScreen")
    object DogDetailScreen: ScreenIdentifier("dogDetailScreen")
}