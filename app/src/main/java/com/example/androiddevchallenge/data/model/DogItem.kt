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
package com.example.androiddevchallenge.data.model

data class DogItem(
    val name: String,
    val location: String,
    val stars: Int,
    val price: Int,
    val type: String,
    val desc: String,
    val image: String,
    val breedCharacteristics: BreedCharacteristics,
    val source: String
)

data class BreedCharacteristics(
    val adaptability: Adaptability,
    val allAroundFriendliness: AllAroundFriendliness,
    val healthAndGroomingNeeds: HealthAndGroomingNeeds,
    val trainability: Trainability,
    val physicalNeeds: PhysicalNeeds,
)

data class Adaptability(
    val adatpsWellToApartmentLiving: Int,
    val goodForNoviceOwners: Int,
    val sensitivityLevel: Int,
    val toleratesBeingAlone: Int,
    val toleratesColdWeather: Int,
    val toleratesHotWeather: Int
)

data class AllAroundFriendliness(
    val affectionateWithFamily: Int,
    val kidFriendly: Int,
    val dogFriendly: Int,
    val friendlyTowardStrangers: Int
)

data class HealthAndGroomingNeeds(
    val amountOfShedding: Int,
    val droolingPotential: Int,
    val easyToGroom: Int,
    val generalHealth: Int,
    val potentialForWeightGain: Int,
    val size: Int
)

data class Trainability(
    val easyToTrain: Int,
    val intelligence: Int,
    val potentialForMouthiness: Int,
    val preyDrive: Int,
    val tendencyToBarkOrHowl: Int,
    val wanderlustPotential: Int
)
data class PhysicalNeeds(
    val energyLevel: Int,
    val intensity: Int,
    val exerciseNeeds: Int,
    val potentialForPlayfulness: Int
)
