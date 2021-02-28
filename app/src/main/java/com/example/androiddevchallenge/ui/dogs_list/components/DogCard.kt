/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.dogs_list.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.ui.theme.blackAlpha
import com.example.androiddevchallenge.ui.theme.lightGray
import com.example.androiddevchallenge.util.loadPictureFromNetwork

@Composable
fun DogCard(
    modifier: Modifier,
    dogItem: DogItem,
    onClick: () -> Unit
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier.clickable(onClick = onClick),
        elevation = 8.dp
    ) {
        Column {
            Box {
                val image = loadPictureFromNetwork(url = dogItem.image).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "Dog Image ${dogItem.type}",
                        modifier = Modifier.fillMaxWidth().height(250.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                    color = blackAlpha,
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth()
                            .padding(8.dp),
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_baseline_location_on),
                            modifier = Modifier.wrapContentWidth().padding(4.dp),
                            contentDescription = "Arrow Right"
                        )
                        Text(
                            text = dogItem.location,
                            modifier = Modifier.align(Alignment.CenterVertically),
                            color = Color.White,
                            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold)
                        )

                    }
                }
            }
            BasicInfo(name = dogItem.name, stars = dogItem.stars, type = dogItem.type)
            PriceInfo(dogItem.price)
            DogDescription(dogItem.desc)

        }
    }
}

@Composable
fun BasicInfo(name: String, stars: Int, type: String) {
    Text(
        text = name,
        style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
        modifier = Modifier.padding(8.dp)
    )

    Row(
        modifier = Modifier.padding(start = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val remainder = 5 - stars
        repeat(stars) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_star_12),
                contentDescription = "Star Filled"
            )
        }
        repeat(remainder) {
            Image(
                painter = painterResource(id = R.drawable.ic_baseline_star_border_12),
                contentDescription = "Star Border"
            )
        }

        Text(
            text = "$stars",
            style = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier.padding(start = 8.dp)
        )

        Text(
            text = "(${type})",
            color = Color.Gray,
            modifier = Modifier.padding(start = 8.dp)
        )
    }
}

@Composable
fun PriceInfo(price: Int) {
    val discountPrice = (price * 0.8).toInt()
    Row(
        modifier = Modifier.fillMaxWidth().padding(end = 8.dp, top = 8.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(text = "20%~", color = Color.Red, fontWeight = FontWeight.Bold)
        Text(
            text = "$$price",
            textDecoration = TextDecoration.LineThrough,
            modifier = Modifier.padding(start = 4.dp),
            color = Color.Gray
        )
    }

    Row(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 8.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "$",
            modifier = Modifier.padding(end = 4.dp)
        )
        Text(
            text = "$discountPrice",
            style = TextStyle(fontSize = 22.sp, fontWeight = FontWeight.Bold)
        )
    }
}

@Composable
fun DogDescription(desc: String) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(top = 4.dp),
    ) {
        Surface(color = lightGray) {
            Text(
                text = desc,
                modifier = Modifier.padding(8.dp),
                color = Color.Gray,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}