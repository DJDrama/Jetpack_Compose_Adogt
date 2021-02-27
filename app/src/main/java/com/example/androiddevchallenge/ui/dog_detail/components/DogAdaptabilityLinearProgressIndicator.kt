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

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DogAdaptabilityLinearProgressIndicator(level: Int) {
    val xStart = remember { Animatable(0f) }
    val xTarget = (level / 10.toFloat()) * 2

    LaunchedEffect(Unit) {
        xStart.animateTo(
            targetValue = xTarget,
            animationSpec = tween(
                durationMillis = 1500,
                easing = FastOutSlowInEasing
            )
        )
    }

    Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
        Text(
            text = "1",
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.wrapContentWidth().padding(start = 8.dp)
        )
        LinearProgressIndicator(
            progress = xStart.value,
            modifier = Modifier.weight(1f).padding(8.dp),
        )
        Text(
            text = "5",
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.wrapContentWidth().padding(end = 8.dp)
        )
    }
}
