package com.example.rickandmortybenja.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.example.rickandmortybenja.ui.theme.RickAndMortyBenjaTheme

@Composable
fun RickAndMortyApp() {
    RickAndMortyBenjaTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            RickAndMortyActions(navController)
        }

        RickAndMortyNavGraph(
            navController = navController,
            navigateToHome = navigationActions.navigateToHome,
            navigateToDetail = navigationActions.navigateToDetail
        )
    }
}