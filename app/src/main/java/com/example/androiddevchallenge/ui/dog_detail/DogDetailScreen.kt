package com.example.androiddevchallenge.ui.dog_detail

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.UNKNOWN_DOG_ITEM
import com.example.androiddevchallenge.ui.dog_detail.components.DogDetailScrollableColumn
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DogDetailScreen(
    viewModel: DogDetailViewModel,
    dogName: String,
    upPress: () -> Unit,
    darkTheme: Boolean
) {
    MyTheme(
        darkTheme = darkTheme
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Back to List") },
                    navigationIcon = {
                        IconButton(onClick = upPress) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back to List"
                            )
                        }
                    }
                )
            }
        ) {
            if (dogName == UNKNOWN_DOG_ITEM.name) {
                // Unknown Error

            } else {
                DogDetailScrollableColumn(viewModel, dogName)
            }
        }
    }
}

