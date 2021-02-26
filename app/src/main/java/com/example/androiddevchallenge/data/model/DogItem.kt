package com.example.androiddevchallenge.data.model

data class DogItem(
    val name: String,
    val image: String,
    val adaptability: Adaptability
)

data class Adaptability(
    val adatpsWellToApartmentLiving: Int,
    val goodForNoviceOwners: Int,
    val sensitivityLevel: Int,
    val toleratesBeingAlone: Int,
    val toleratesColdWeather: Int,
    val toleratesHotWeather: Int

)