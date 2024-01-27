package com.ppam.wishlistapp.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ppam.wishlistapp.ui.screens.AddEditDetailView
import com.ppam.wishlistapp.ui.screens.HomeView
import com.ppam.wishlistapp.viewModel.WishViewModel

@Composable
fun Navigation(viewModel: WishViewModel = viewModel(),
               navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController,
        startDestination = Screen.HomeScreen.route){
        // Registering 1st screen to navigation
        composable(Screen.HomeScreen.route) {
            HomeView(navController, viewModel)
        }

//      Registering 2nd screen to navigation
        composable(Screen.AddScreen.route) {
            AddEditDetailView(id = 0L,
                viewModel = viewModel,
                navController = navController)
        }
    }
}