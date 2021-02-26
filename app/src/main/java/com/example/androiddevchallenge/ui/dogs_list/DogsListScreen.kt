package com.example.androiddevchallenge.ui.dogs_list

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.dogs_list.components.DogsList

@Composable
fun DogsListScreen(
    viewModel: DogsListViewModel,
    onNavigateToDogDetailScreen: (String) -> Unit,
) {
    val dogs = viewModel.dogs

    DogsList(
        loading = false,
        dogItems = dogs.value,
        onNavigateToDogDetailScreen = onNavigateToDogDetailScreen
    )
}