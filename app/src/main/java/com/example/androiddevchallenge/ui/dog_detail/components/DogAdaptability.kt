package com.example.androiddevchallenge.ui.dog_detail.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.model.DogItem

@Composable
fun DogAdaptability(dogItem: DogItem) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp, top = 16.dp),
        elevation = 8.dp
    ) {
        Column {

            Text(
                "Adaptability",
                modifier = Modifier.align(Alignment.CenterHorizontally).padding(8.dp),
                style = MaterialTheme.typography.h5
            )

            Divider(
                modifier = Modifier.fillMaxWidth().padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            )

            DogAdaptabilityInfo(
                "Adapts Well To Apartment Living",
                dogItem.adaptability.adatpsWellToApartmentLiving
            )
            DogAdaptabilityInfo(
                "Good For Novice Owners",
                dogItem.adaptability.goodForNoviceOwners
            )
            DogAdaptabilityInfo(
                "Sensitivity Level",
                dogItem.adaptability.sensitivityLevel
            )
            DogAdaptabilityInfo(
                "Tolerates Being Alone",
                dogItem.adaptability.toleratesBeingAlone
            )
            DogAdaptabilityInfo(
                "Tolerates Cold Weather",
                dogItem.adaptability.toleratesColdWeather
            )
            DogAdaptabilityInfo(
                "Tolerates Hot Weather",
                dogItem.adaptability.toleratesHotWeather
            )
        }
    }
}