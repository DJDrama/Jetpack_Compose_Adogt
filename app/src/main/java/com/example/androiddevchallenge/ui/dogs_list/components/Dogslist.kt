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

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.repeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.ui.navigation.ScreenRoute

@ExperimentalAnimationApi
@Composable
fun DogsList(
    isLoading: Boolean,
    dogItems: List<DogItem>,
    onNavigateToDogDetailScreen: (String) -> Unit
) {
    Box {
        if (isLoading) {
            LoadingAnimation()
        } else {
            LazyColumn {
                itemsIndexed(
                    items = dogItems,
                    itemContent = { index, dogItem ->
                        AnimatedListItem(
                            dogItem = dogItem,
                            index = index,
                            onNavigateToDogDetailScreen = onNavigateToDogDetailScreen
                        )
                    }
                )
            }
        }
    }
}

@Composable
fun LoadingAnimation() {
    // Logo Anim
    val logoAnimatedProgress = remember { Animatable(initialValue = 0f) }
    LaunchedEffect(Unit) {
        logoAnimatedProgress.animateTo(
            targetValue = 360f,
            animationSpec = repeatable(
                iterations = 100,
                animation = tween(
                    durationMillis = 500, easing = LinearEasing
                )
            )
        )
    }

    // Text Anim
    val textAnimatedProgress = remember { Animatable(initialValue = 0f) }
    LaunchedEffect(Unit) {
        textAnimatedProgress.animateTo(
            targetValue = 3f,
            animationSpec = repeatable(
                iterations = 100,
                animation = tween(
                    durationMillis = 1000, easing = LinearEasing
                )
            )
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = null,
            modifier = Modifier
                .graphicsLayer(
                    rotationY = logoAnimatedProgress.value
                )
        )
        Text(
            text = "Loading${
                when (textAnimatedProgress.value.toInt()) {
                    0 -> "."
                    1 -> ".."
                    2 -> "..."
                    else -> "."
                }
            }",
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}

@Composable
fun AnimatedListItem(dogItem: DogItem, index: Int, onNavigateToDogDetailScreen: (String) -> Unit) {
    val animatedProgress = remember { Animatable(initialValue = -300f) }
    LaunchedEffect(Unit) {
        animatedProgress.animateTo(
            targetValue = 0f,
            animationSpec = tween(300, easing = FastOutSlowInEasing)
        )
    }
    val topPadding = if (index == 0) 16.dp else 8.dp

    val animatedModifier = Modifier
        .graphicsLayer(translationX = animatedProgress.value)
        .fillMaxWidth()
        .padding(start = 8.dp, end = 8.dp, top = topPadding, bottom = 8.dp)

    DogCard(
        modifier = animatedModifier,
        dogItem = dogItem,
        onClick = {
            val navRoute = ScreenRoute.DogDetailScreen.route + "/${dogItem.name}"
            onNavigateToDogDetailScreen(navRoute)
        }
    )
}
