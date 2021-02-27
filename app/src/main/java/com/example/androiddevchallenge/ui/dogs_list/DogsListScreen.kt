package com.example.androiddevchallenge.ui.dogs_list

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.dogs_list.components.DogsList
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun DogsListScreen(
    viewModel: DogsListViewModel,
    onNavigateToDogDetailScreen: (String) -> Unit,
    darkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    MyTheme(
        darkTheme = darkTheme
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row {
                            Image(
                                painter = painterResource(R.drawable.logo),
                                contentDescription = null
                            )
                            Text(
                                text = "Let's Adogt!",
                                modifier = Modifier.padding(start = 8.dp)
                                    .align(Alignment.CenterVertically)
                            )
                        }
                    },
                    actions = {
                        CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                            IconButton(
                                onClick = { /* TODO: Open account? */ }
                            ) {
                                Icon(
                                    imageVector = Icons.Filled.Search,
                                    contentDescription = stringResource(id = R.string.search)
                                )
                            }
                            IconButton(
                                onClick = onToggleTheme
                            ) {
                                Icon(
                                    imageVector = Icons.Outlined.MoreVert,
                                    contentDescription = stringResource(id = R.string.more)
                                )
                            }
                        }
                    }
                )
            }
        ) {
            val dogs = viewModel.dogs
            DogsList(
                dogItems = dogs.value,
                onNavigateToDogDetailScreen = onNavigateToDogDetailScreen
            )
        }
    }
}