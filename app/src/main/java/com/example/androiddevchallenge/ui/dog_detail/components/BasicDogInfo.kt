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

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Pets
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.ui.dogs_list.components.PriceInfo
import com.example.androiddevchallenge.ui.theme.orangeYellow

@Composable
fun BasicDogInfo(dogItem: DogItem) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = dogItem.name,
            style = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
        )
        Icon(
            imageVector = Icons.Outlined.FavoriteBorder,
            contentDescription = "Favorite",
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            imageVector = Icons.Filled.Pets,
            contentDescription = "Type",
            modifier = Modifier.size(16.dp)
        )
        Text(
            text = dogItem.type,
            fontSize = 14.sp,
            modifier = Modifier.padding(start = 4.dp)
        )
    }

    Row(verticalAlignment = Alignment.Bottom, modifier = Modifier.padding(vertical = 8.dp)) {
        Icon(
            imageVector = Icons.Filled.Star,
            contentDescription = "Star Filled",
            tint = orangeYellow,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = "${dogItem.stars}",
            style = TextStyle(fontSize = 24.sp),
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 4.dp)
        )
        Text(
            text = "/5",
            color = Color.Gray,
        )
    }
    PriceInfo(price = dogItem.price)
}
