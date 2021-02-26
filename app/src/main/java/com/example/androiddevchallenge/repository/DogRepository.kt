package com.example.androiddevchallenge.repository

import com.example.androiddevchallenge.data.UNKNOWN_DOG_ITEM
import com.example.androiddevchallenge.data.dogsList
import com.example.androiddevchallenge.data.model.DogItem

class DogRepository {
    fun getAllDogItems(): List<DogItem> {
        return dogsList
    }
    fun getDogItem(dogName: String): DogItem {
        val res = dogsList.find {
            it.name == dogName
        }
        return res?.let{
            it
        } ?: UNKNOWN_DOG_ITEM
    }
}