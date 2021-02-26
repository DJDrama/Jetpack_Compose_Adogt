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
package com.example.androiddevchallenge.ui

import android.content.Context
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.ui.dog_detail.DogDetailScreen
import com.example.androiddevchallenge.ui.dog_detail.DogDetailViewModel
import com.example.androiddevchallenge.ui.dogs_list.DogsListScreen
import com.example.androiddevchallenge.ui.dogs_list.DogsListViewModel
import com.example.androiddevchallenge.ui.navigation.ScreenIdentifier
import com.example.androiddevchallenge.ui.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.internal.lifecycle.HiltViewModelFactory


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            MyTheme {
//                MyApp()
//            }
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = ScreenIdentifier.DogsListScreen.identifier
            ) {
                composable(route = ScreenIdentifier.DogsListScreen.identifier) { navBackStackEntry ->
                    val viewModelFactory =
                        HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                    val viewModel = viewModel<DogsListViewModel>(
                        ScreenIdentifier.DogsListScreen.identifier,
                        viewModelFactory
                    )
                    DogsListScreen(
                        viewModel = viewModel,
                        onNavigateToDogDetailScreen = navController::navigate
                    )
                }

                composable(
                    route = ScreenIdentifier.DogDetailScreen.identifier + "/{dogName}",
                    arguments = listOf(
                        navArgument("dogName") {
                            type = NavType.StringType
                        }
                    )
                ) { navBackStackEntry ->
                    val viewModelFactory =
                        HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                    val viewModel = viewModel<DogDetailViewModel>(
                        ScreenIdentifier.DogDetailScreen.identifier,
                        viewModelFactory
                    )
                    DogDetailScreen(
                        viewModel = viewModel,
                        dogName = navBackStackEntry.arguments?.getString("dogName") ?: ""
                    )
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp() {
    Surface(color = MaterialTheme.colors.background) {
        Text(text = "Ready... Set... GO!")
    }
}

@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        MyApp()
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        MyApp()
    }
}
