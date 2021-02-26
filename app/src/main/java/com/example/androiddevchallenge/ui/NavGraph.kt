package com.example.androiddevchallenge.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.ui.dog_detail.DogDetailScreen
import com.example.androiddevchallenge.ui.dog_detail.DogDetailViewModel
import com.example.androiddevchallenge.ui.dogs_list.DogsListScreen
import com.example.androiddevchallenge.ui.dogs_list.DogsListViewModel
import com.example.androiddevchallenge.ui.navigation.ScreenIdentifier

@Composable
fun NavGraph(startDestination: String = ScreenIdentifier.DogsListScreen.route){
    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = ScreenIdentifier.DogsListScreen.route) { navBackStackEntry ->
            val viewModelFactory =
                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel = viewModel<DogsListViewModel>(
                ScreenIdentifier.DogsListScreen.route,
                viewModelFactory
            )
            DogsListScreen(
                viewModel = viewModel,
                onNavigateToDogDetailScreen = navController::navigate
            )
        }

        composable(
            route = ScreenIdentifier.DogDetailScreen.route + "/{dogName}",
            arguments = listOf(
                navArgument("dogName") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val viewModelFactory =
                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel = viewModel<DogDetailViewModel>(
                ScreenIdentifier.DogDetailScreen.route,
                viewModelFactory
            )
            DogDetailScreen(
                viewModel = viewModel,
                dogName = navBackStackEntry.arguments?.getString("dogName") ?: "",
                upPress = actions.upPress
            )
        }
    }

}

class MainActions(navController: NavController){
    val upPress: ()->Unit = {
        navController.navigateUp()
    }
}