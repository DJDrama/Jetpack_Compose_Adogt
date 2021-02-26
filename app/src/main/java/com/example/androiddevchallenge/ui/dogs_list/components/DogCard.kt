package com.example.androiddevchallenge.ui.dogs_list.components

import android.app.SharedElementCallback
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.util.loadPictureFromNetwork
import com.example.androiddevchallenge.R

@Composable
fun DogCard(dogItem: DogItem, onClick: () -> Unit) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth().padding(8.dp).clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column {
            Box {
                val image = loadPictureFromNetwork(url = dogItem.image).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "Dog Image",
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                    color = Color(0xFF70000000),
                ) {

                    val resource = painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24)

                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(8.dp),
                    ) {
                        Text(
                            text = dogItem.name,
                            modifier = Modifier.wrapContentWidth(Alignment.Start),
                            color = Color.White,
                            style = MaterialTheme.typography.h6
                        )
                        Image(
                            painter = resource,
                            modifier = Modifier.fillMaxWidth().wrapContentWidth(Alignment.End),
                            contentDescription = "Arrow Right"
                        )

                    }
                }
            }

        }
    }
}
