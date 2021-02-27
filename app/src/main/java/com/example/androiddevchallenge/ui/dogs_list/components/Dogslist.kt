package com.example.androiddevchallenge.ui.dogs_list.components

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.ui.navigation.ScreenRoute

@Composable
fun DogsList(
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
                    val navRoute = ScreenRoute.DogDetailScreen.route + "/${dogItem.name}"
                    onNavigateToDogDetailScreen(navRoute)
                }
            )
        }
    }
}