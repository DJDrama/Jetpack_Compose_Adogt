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
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.ui.theme.blackAlpha
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
                        contentDescription = "Dog Image ${dogItem.name}",
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Surface(
                    modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                    color = blackAlpha,
                ) {

                    val resource =
                        painterResource(id = R.drawable.ic_baseline_keyboard_arrow_right_24)

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
