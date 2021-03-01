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
package com.example.androiddevchallenge.ui.dog_detail

import android.graphics.Bitmap
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.ui.dog_detail.components.BasicDogInfo
import com.example.androiddevchallenge.ui.dog_detail.components.DogAdaptability
import com.example.androiddevchallenge.ui.dog_detail.components.DogDescription
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.util.loadPictureFromNetwork

@Composable
fun DogDetailScreen(
    viewModel: DogDetailViewModel,
    dogName: String,
    upPress: () -> Unit,
    darkTheme: Boolean
) {
    val scaffoldState = rememberScaffoldState()
    val scrollState = rememberScrollState(0)
    val dogItem = viewModel.getDogItem(dogName = dogName)
    val image = loadPictureFromNetwork(url = dogItem.image).value

    MyTheme(
        darkTheme = darkTheme,
        scaffoldState = scaffoldState
    ) {
        Scaffold(
            scaffoldState = scaffoldState,
            snackbarHost = {
                scaffoldState.snackbarHostState
            }
        ) {
            Box(modifier = Modifier.fillMaxSize()) {
                BoxTopSection(image)
                TopSectionOverlay(scrollState = scrollState)
                BottomScrollableContent(scrollState = scrollState, dogItem = dogItem, scaffoldState = scaffoldState)
                AnimatedToolBar(name = dogItem.name, scrollState = scrollState, upPress = upPress)
            }
        }
    }
}

@Composable
fun BoxTopSection(image: Bitmap?) {
    image?.let { img ->
        Image(
            bitmap = img.asImageBitmap(),
            contentDescription = "Dog Image",
            modifier = Modifier.fillMaxWidth().height(350.dp),
            contentScale = ContentScale.Crop
        )
    }
}

@Composable
fun TopSectionOverlay(scrollState: ScrollState) {
    val dynamicAlpha = ((scrollState.value.toFloat()) / 1000).coerceIn(0f, 1f)
    Box(
        modifier = Modifier.fillMaxWidth()
            .height(350.dp)
            .background(
                MaterialTheme.colors.surface.copy(
                    alpha = animateFloatAsState(dynamicAlpha).value
                )
            )
    )
}

@Composable
fun BottomScrollableContent(scrollState: ScrollState, dogItem: DogItem, scaffoldState: ScaffoldState) {
    Column(modifier = Modifier.verticalScroll(state = scrollState)) {
        Spacer(modifier = Modifier.height(320.dp))
        ScrollSection(dogItem = dogItem, scaffoldState = scaffoldState)
    }
}

@Composable
fun ScrollSection(dogItem: DogItem, scaffoldState: ScaffoldState) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(topStart = 32.dp, topEnd = 32.dp)
    ) {
        Column(modifier = Modifier.padding(horizontal = 16.dp)) {
            BasicDogInfo(dogItem = dogItem, scaffoldState = scaffoldState)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            DogAdaptability(dogItem = dogItem)
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            DogDescription(dogItem = dogItem)
            Button(
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(bottom = 32.dp),
                onClick = {
                }
            ) {
                Text("Adopt ${dogItem.name}")
            }
        }
    }
}

@Composable
fun AnimatedToolBar(name: String, scrollState: ScrollState, upPress: () -> Unit) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (Dp(scrollState.value.toFloat()) < 770.dp)
                    Color.Transparent
                else
                    MaterialTheme.colors.surface
            )
            .padding(horizontal = 8.dp, vertical = 4.dp)
    ) {
        IconButton(onClick = upPress) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = "Back to List",
                tint = if (Dp(scrollState.value.toFloat()) < 770.dp)
                    Color.White
                else
                    MaterialTheme.colors.onSurface
            )
        }
        Text(
            text = name,
            color =
            if (Dp(scrollState.value.toFloat()) < 770.dp)
                Color.White
            else MaterialTheme.colors.onSurface,
            modifier = Modifier
                .padding(16.dp)
                .alpha(
                    ((scrollState.value + 0.001f) / 1000)
                        .coerceIn(0f, 1f)
                )
        )

        Icon(
            imageVector = Icons.Filled.Share,
            contentDescription = "Share",
            tint = if (Dp(scrollState.value.toFloat()) < 800.dp)
                Color.White
            else
                MaterialTheme.colors.onSurface
        )
    }
}
