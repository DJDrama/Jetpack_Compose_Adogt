package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.data.dogsList
import com.example.androiddevchallenge.data.model.DogItem

class DogRepository {

    fun getAllDogItems(): List<DogItem> {
        return dogsList
    }
}