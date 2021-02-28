/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.dogs_list

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ContentAlpha
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
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

@ExperimentalAnimationApi
@Composable
fun DogsListScreen(
    viewModel: DogsListViewModel,
    onNavigateToDogDetailScreen: (String) -> Unit,
    darkTheme: Boolean,
    onToggleTheme: () -> Unit
) {
    val isLoading = viewModel.loading.value
    val dogs = viewModel.dogs.value

    MyTheme(
        darkTheme = darkTheme
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row {
                            Image(
                                modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
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
                                onClick = { }
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
            DogsList(
                isLoading = isLoading,
                dogItems = dogs,
                onNavigateToDogDetailScreen = onNavigateToDogDetailScreen
            )
        }
    }
}
