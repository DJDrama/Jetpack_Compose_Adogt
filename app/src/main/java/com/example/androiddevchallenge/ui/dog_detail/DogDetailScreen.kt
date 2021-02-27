package com.example.androiddevchallenge.ui.dog_detail

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.*
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.androiddevchallenge.data.UNKNOWN_DOG_ITEM
import com.example.androiddevchallenge.data.model.DogItem
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.util.loadPictureFromNetwork

@Composable
fun DogDetailScreen(
    viewModel: DogDetailViewModel,
    dogName: String,
    upPress: () -> Unit,
    darkTheme: Boolean
) {
    MyTheme(
        darkTheme = darkTheme
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = { Text("Back to List") },
                    navigationIcon = {
                        IconButton(onClick = upPress) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = "Back to List"
                            )
                        }
                    }
                )
            }
        ) {
            if (dogName == UNKNOWN_DOG_ITEM.name) {
                // Unknown Error

            } else {
                DogDetailScrollableColumn(viewModel, dogName)
            }
        }
    }
}

@Composable
fun DogDetailScrollableColumn(
    viewModel: DogDetailViewModel,
    dogName: String
) {

    val uriHandler = LocalUriHandler.current
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        item {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                val dogItem = viewModel.getDogItem(dogName = dogName)
                val image = loadPictureFromNetwork(url = dogItem.image).value
                image?.let { img ->
                    Image(
                        bitmap = img.asImageBitmap(),
                        contentDescription = "Dog Image",
                        modifier = Modifier.fillMaxWidth().height(250.dp),
                        contentScale = ContentScale.Crop
                    )
                }

                Text(
                    text = dogItem.name,
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    style = MaterialTheme.typography.h4
                )

                Text(
                    text = dogItem.desc,
                    modifier = Modifier.fillMaxWidth().wrapContentHeight().padding(8.dp),
                    style = TextStyle(fontSize = 16.sp)
                )

                DogAdaptability(dogItem = dogItem)


                val sourceStr = dogItem.source
                val sourceText = buildAnnotatedString {
                    append(sourceStr)
                    addStyle(
                        style = SpanStyle(
                            color = Color.Blue,
                            textDecoration = TextDecoration.Underline,
                        ),
                        start = 0,
                        end = sourceStr.length
                    )
                    addStringAnnotation(
                        tag = "URL",
                        annotation = dogItem.source,
                        start = 0,
                        end = sourceStr.length
                    )
                }

                Row(
                    modifier = Modifier.fillMaxWidth().padding(
                        start = 8.dp,
                        top = 16.dp,
                        bottom = 16.dp,
                        end = 8.dp
                    )
                ) {
                    Text("Source: ")
                    Spacer(modifier = Modifier.size(4.dp))
                    ClickableText(
                        text = sourceText,
                        modifier = Modifier.wrapContentWidth(),
                        onClick = {
                            sourceText.getStringAnnotations("URL", 0, sourceStr.length)
                                .firstOrNull()?.let { stringAnnotation ->
                                    uriHandler.openUri(stringAnnotation.item)
                                }
                        }
                    )
                }

                Button(modifier = Modifier.align(Alignment.CenterHorizontally)
                    .padding(bottom = 32.dp),
                    onClick = {

                    }) {
                    Text("Adopt ${dogItem.name}")
                }

            }
        }
    }
}

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
