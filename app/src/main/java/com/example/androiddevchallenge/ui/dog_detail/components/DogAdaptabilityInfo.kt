package com.example.androiddevchallenge.ui.dog_detail.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun DogAdaptabilityInfo(title: String, level: Int) {
    Row(Modifier.padding(8.dp)) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.wrapContentWidth()
        )

        Text(
            text = "($level)",
            color = Color.Gray,
            style = TextStyle(fontSize = 14.sp),
            modifier = Modifier.fillMaxHeight().align(Alignment.CenterVertically)
                .padding(start = 8.dp)
        )
    }

    DogAdaptabilityLinearProgressIndicator(level)
}
