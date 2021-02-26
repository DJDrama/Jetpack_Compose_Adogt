package com.example.androiddevchallenge.ui.dogs_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.ui.navigation.ScreenIdentifier

@Composable
fun DogsList(
    loading: Boolean,
    dogItems: List<DogItem>,
    onNavigateToDogDetailScreen: (String) -> Unit
){
    LazyColumn{
        itemsIndexed(
            items = dogItems
        ){index, dogItem->
            DogCard(
                dogItem = dogItem,
                onClick = {
                    val navRoute = ScreenIdentifier.DogDetailScreen.route + "/${dogItem.name}"
                    onNavigateToDogDetailScreen(navRoute)
                }
            )
        }
    }
}