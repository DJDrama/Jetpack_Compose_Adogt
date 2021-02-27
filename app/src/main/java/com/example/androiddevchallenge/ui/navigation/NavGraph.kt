package com.example.androiddevchallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.androiddevchallenge.datastore.DataStoreImpl
import com.example.androiddevchallenge.ui.dog_detail.DogDetailScreen
import com.example.androiddevchallenge.ui.dog_detail.DogDetailViewModel
import com.example.androiddevchallenge.ui.dogs_list.DogsListScreen
import com.example.androiddevchallenge.ui.dogs_list.DogsListViewModel

@Composable
fun NavGraph(startDestination: String = ScreenRoute.DogsListScreen.route, dataStore: DataStoreImpl){

    val navController = rememberNavController()
    val actions = remember(navController) { MainActions(navController) }

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable(route = ScreenRoute.DogsListScreen.route) { navBackStackEntry ->
            val viewModelFactory =
                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel = viewModel<DogsListViewModel>(
                ScreenRoute.DogsListScreen.route,
                viewModelFactory
            )
            DogsListScreen(
                viewModel = viewModel,
                onNavigateToDogDetailScreen = navController::navigate,
                darkTheme = dataStore.isDark.value,
                onToggleTheme = dataStore::toggleTheme
            )
        }

        composable(
            route = ScreenRoute.DogDetailScreen.route + "/{dogName}",
            arguments = listOf(
                navArgument("dogName") {
                    type = NavType.StringType
                }
            )
        ) { navBackStackEntry ->
            val viewModelFactory =
                HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val viewModel = viewModel<DogDetailViewModel>(
                ScreenRoute.DogDetailScreen.route,
                viewModelFactory
            )
            DogDetailScreen(
                viewModel = viewModel,
                dogName = navBackStackEntry.arguments?.getString("dogName") ?: "",
                upPress = actions.upPress,
                darkTheme = dataStore.isDark.value
            )
        }
    }

}

class MainActions(navController: NavController){
    val upPress: ()->Unit = {
        navController.navigateUp()
    }
}