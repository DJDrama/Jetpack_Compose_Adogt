package com.example.androiddevchallenge.ui.dogs_list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.repository.DogRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DogsListViewModel
@Inject
constructor(
    private val repository: DogRepository
) : ViewModel() {

    private val _dogs: MutableState<List<DogItem>> = mutableStateOf(ArrayList())
    val dogs: State<List<DogItem>>
        get() = _dogs

    init {
        retrieveDogItems()
    }

    private fun retrieveDogItems() {
        _dogs.value = repository.getAllDogItems()
    }
}