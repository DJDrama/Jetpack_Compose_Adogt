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
package com.example.androiddevchallenge.ui.dog_detail.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.ui.dog_detail.DogDetailViewModel
import com.example.androiddevchallenge.util.loadPictureFromNetwork

@Composable
fun DogDetailScrollableColumn(
    viewModel: DogDetailViewModel,
    dogName: String
) {
    val uriHandler = LocalUriHandler.current
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                val dogItem = viewModel.getDogItem(dogName = dogName)
                val image = loadPictureFromNetwork(url = dogItem.image).value

                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "Dog Image",
                        modifier = Modifier.fillMaxWidth().height(200.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                DogAdaptability(dogItem = dogItem)

                Text(
                    text = dogItem.type,
                    modifier = Modifier.fillMaxWidth()
                        .padding(
                            horizontal = 8.dp, vertical = 16.dp
                        ),
                    style = MaterialTheme.typography.h4
                )

                Text(
                    text = dogItem.desc,
                    modifier = Modifier.fillMaxWidth().wrapContentHeight()
                        .padding(horizontal = 8.dp),
                    style = TextStyle(fontSize = 16.sp)
                )

                val sourceStr = dogItem.source
                val sourceText = buildAnnotatedString {
                    append(sourceStr)
                    addStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline,
                        ),
                        start = 0,
                        end = sourceStr.length
                    )
                    addStringAnnotation(
                        tag = "URL",
                        annotation = dogItem.source,
                        start = 0,
                        end = sourceStr.length
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(
                        start = 8.dp,
                        top = 16.dp,
                        bottom = 16.dp,
                        end = 8.dp
                    )
                ) {
                    Text("Source: ")
                    Spacer(modifier = Modifier.size(4.dp))
                    ClickableText(
                        text = sourceText,
                        modifier = Modifier.wrapContentWidth(),
                        onClick = {
                            sourceText.getStringAnnotations("URL", 0, sourceStr.length)
                                .firstOrNull()?.let { stringAnnotation ->
                                    uriHandler.openUri(stringAnnotation.item)
                                }
                        }
                    )
                }

                Button(
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(bottom = 32.dp),
                    onClick = {
                    }
                ) {
                    Text("Adopt ${dogItem.type}")
                }
            }
        }
    }
}
