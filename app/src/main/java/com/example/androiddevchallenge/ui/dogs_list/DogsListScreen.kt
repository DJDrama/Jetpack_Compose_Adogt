package com.example.androiddevchallenge.ui.dogs_list

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.ui.dogs_list.components.DogsList

@Composable
fun DogsListScreen(
    viewModel: DogsListViewModel,
    onNavigateToDogDetailScreen: (String) -> Unit,
) {
    val scaffoldState = rememberScaffoldState()
    Scaffold(
        topBar = { TopAppBar({ Text("Let's Adopt!") }) }
    ){
        val dogs = viewModel.dogs
        DogsList(
            loading = false,
            dogItems = dogs.value,
            onNavigateToDogDetailScreen = onNavigateToDogDetailScreen
        )
    }

}