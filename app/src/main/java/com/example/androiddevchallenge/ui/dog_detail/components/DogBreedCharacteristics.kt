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
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.model.Adaptability
import com.example.androiddevchallenge.data.model.AllAroundFriendliness
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.data.model.HealthAndGroomingNeeds
import com.example.androiddevchallenge.data.model.PhysicalNeeds
import com.example.androiddevchallenge.data.model.Trainability
import com.example.androiddevchallenge.ui.components.Pager
import com.example.androiddevchallenge.ui.components.PagerState
import kotlinx.coroutines.launch

@Composable
fun DogBreedCharacteristics(dogItem: DogItem) {
    val pagerState = remember { PagerState() }
    val breedCharacteristics = dogItem.breedCharacteristics
    val list = mutableListOf<Any>()
    list.add(breedCharacteristics.adaptability)
    list.add(breedCharacteristics.allAroundFriendliness)
    list.add(breedCharacteristics.healthAndGroomingNeeds)
    list.add(breedCharacteristics.trainability)
    list.add(breedCharacteristics.physicalNeeds)

    BreedCharacteristicsPager(
        items = list,
        pagerState = pagerState
    )
}

@Composable
fun BreedCharacteristicsPager(items: List<Any>, pagerState: PagerState) {
    pagerState.maxPage = (items.size - 1).coerceAtLeast(0)

    Pager(
        state = pagerState,
        modifier = Modifier.fillMaxWidth().requiredHeight(480.dp).padding(12.dp)
    ) {
        Card(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxHeight().padding(horizontal = 4.dp),
            elevation = 8.dp
        ) {
            Column(modifier = Modifier) {
                val item = items[page]
                Text(
                    text = when (page) {
                        0 -> "Adaptability"
                        1 -> "All Around Friendliness"
                        2 -> "Health And Grooming Needs"
                        3 -> "Trainability"
                        4 -> "Physical Needs"
                        else -> "Adaptability"
                    },
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                        .padding(vertical = 8.dp),
                    style = MaterialTheme.typography.h5
                )

                Divider(
                    modifier = Modifier.fillMaxWidth()
                        .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
                )

                val isSelected = currentPage == page

                when (page) {
                    0 -> {
                        val adaptability = item as Adaptability
                        DogCharacteristicsInfo(
                            "Adapts Well To Apartment Living",
                            adaptability.adatpsWellToApartmentLiving,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Good For Novice Owners",
                            adaptability.goodForNoviceOwners,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Sensitivity Level",
                            adaptability.sensitivityLevel,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Tolerates Being Alone",
                            adaptability.toleratesBeingAlone,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Tolerates Cold Weather",
                            adaptability.toleratesColdWeather,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Tolerates Hot Weather",
                            adaptability.toleratesHotWeather,
                            isSelected = isSelected
                        )
                    }
                    1 -> {
                        val allAroundFriendliness = item as AllAroundFriendliness
                        DogCharacteristicsInfo(
                            "Affectionate With Family",
                            allAroundFriendliness.affectionateWithFamily,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Kid-Friendly",
                            allAroundFriendliness.kidFriendly,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Dog-Friendly",
                            allAroundFriendliness.dogFriendly,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Friendly Toward Strangers",
                            allAroundFriendliness.friendlyTowardStrangers,
                            isSelected = isSelected
                        )
                    }
                    2 -> {
                        val healthAndGroomingNeeds = item as HealthAndGroomingNeeds
                        DogCharacteristicsInfo(
                            "Amount Of Shedding",
                            healthAndGroomingNeeds.amountOfShedding,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Drooling Potential",
                            healthAndGroomingNeeds.droolingPotential,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "General Health",
                            healthAndGroomingNeeds.generalHealth,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Potential For Weight Gain",
                            healthAndGroomingNeeds.potentialForWeightGain,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Size",
                            healthAndGroomingNeeds.size,
                            isSelected = isSelected
                        )
                    }
                    3 -> {
                        val trainability = item as Trainability
                        DogCharacteristicsInfo(
                            "Easy to Train",
                            trainability.easyToTrain,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Intelligence",
                            trainability.intelligence,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Potential For Mouthiness",
                            trainability.potentialForMouthiness,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Prey Drive",
                            trainability.preyDrive,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Tendency to Bark or Howl",
                            trainability.tendencyToBarkOrHowl,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Wanderlust Potential",
                            trainability.wanderlustPotential,
                            isSelected = isSelected
                        )
                    }
                    4 -> {
                        val physicalNeeds = item as PhysicalNeeds
                        DogCharacteristicsInfo(
                            "Energy Level",
                            physicalNeeds.energyLevel,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Intensity",
                            physicalNeeds.intensity,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Exercise Needs",
                            physicalNeeds.exerciseNeeds,
                            isSelected = isSelected
                        )
                        DogCharacteristicsInfo(
                            "Potential for Playfulness",
                            physicalNeeds.potentialForPlayfulness,
                            isSelected = isSelected
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun DogCharacteristicsInfo(title: String, level: Int, isSelected: Boolean) {
    Row(
        modifier = Modifier.padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = if (level == 5) FontWeight.Bold else null
            )
        )

        Text(
            text = "($level)",
            color = Color.Gray,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.padding(start = 8.dp)
        )
    }

    DogLinearProgressIndicator(level, isSelected)
}

@Composable
fun DogLinearProgressIndicator(level: Int, isSelected: Boolean) {
    val xTarget = (level / 10.toFloat()) * 2

    val xStart = remember { mutableStateOf(Animatable(0f)) }
    val coroutineScope = rememberCoroutineScope()
    if (!isSelected)
        xStart.value = Animatable(0f)

    coroutineScope.launch {
        xStart.value.animateTo(
            targetValue = xTarget,
            animationSpec = tween(
                durationMillis = 150,
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
            progress = xStart.value.value,
            modifier = Modifier.weight(1f).padding(8.dp),
        )
        Text(
            text = "5",
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.wrapContentWidth().padding(end = 8.dp)
        )
    }
}
