package com.example.androiddevchallenge.ui.navigation

sealed class ScreenIdentifier(
    val identifier: String
) {
    object DogsListScreen: ScreenIdentifier("dogsListScreen")
    object DogDetailScreen: ScreenIdentifier("dogDetailScreen")
}