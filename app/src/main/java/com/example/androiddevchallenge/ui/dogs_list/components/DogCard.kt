package com.example.androiddevchallenge.ui.dogs_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.util.loadPictureFromNetwork

@Composable
fun DogCard(dogItem: DogItem, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        elevation = 8.dp
    ){
        Column{
            val image = loadPictureFromNetwork(url = dogItem.image).value
            image?.let{ img->
                Image(
                    bitmap = img.asImageBitmap(),
                    contentDescription = "Dog Image",
                    modifier = Modifier.fillMaxWidth().height(200.dp),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}