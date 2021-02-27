package com.example.androiddevchallenge.ui.dog_detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DogAdaptabilityLinearProgressIndicator(level: Int) {
    val maxValue = (level / 10.toFloat()) * 2

    Row(modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)) {
        Text(
            text = "1",
            modifier = Modifier.wrapContentWidth().padding(start = 8.dp)
        )
        LinearProgressIndicator(
            progress = maxValue,
            modifier = Modifier.weight(1f).padding(8.dp),
        )
        Text(
            text = "5",
            modifier = Modifier.wrapContentWidth().padding(end = 8.dp)
        )
    }

}