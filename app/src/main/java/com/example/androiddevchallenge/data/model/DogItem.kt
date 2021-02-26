package com.example.androiddevchallenge.data.model

data class DogItem(
    val name: String,
    val desc: String,
    val image: String,
    val adaptability: Adaptability,
    val source: String
)

data class Adaptability(
    val adatpsWellToApartmentLiving: Int,
    val goodForNoviceOwners: Int,
    val sensitivityLevel: Int,
    val toleratesBeingAlone: Int,
    val toleratesColdWeather: Int,
    val toleratesHotWeather: Int

)