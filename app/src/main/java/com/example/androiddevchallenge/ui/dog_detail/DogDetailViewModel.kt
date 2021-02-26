package com.example.androiddevchallenge.ui.dog_detail

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DogDetailViewModel
@Inject
constructor(
    private val repository: DogRepository
) : ViewModel() {

    fun getDogItem(dogName: String): DogItem {
        return repository.getDogItem(dogName)
    }
}