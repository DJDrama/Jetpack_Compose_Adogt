package com.example.androiddevchallenge.ui.dog_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.util.loadPictureFromNetwork

@Composable
fun DogDetailScreen(
    viewModel: DogDetailViewModel,
    dogName: String,
    upPress: () -> Unit
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
        DogDetailScrollableColumn(viewModel, dogName)
    }
}

@Composable
fun DogDetailScrollableColumn(
    viewModel: DogDetailViewModel,
    dogName: String
) {
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            val dogItem = viewModel.getDogItem(dogName = dogName)
            val image = loadPictureFromNetwork(url = dogItem.image).value
            image?.let { img ->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "Dog Image",
                    modifier = Modifier.fillMaxWidth().height(250.dp),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.fillMaxWidth().padding(8.dp)
            ) {
                Text(
                    text = dogItem.name,
                    modifier = Modifier.wrapContentWidth(),
                    style = MaterialTheme.typography.h5
                )
            }
        }

    }
}