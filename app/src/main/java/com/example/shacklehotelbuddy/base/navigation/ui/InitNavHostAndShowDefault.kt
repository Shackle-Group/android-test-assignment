package com.example.shacklehotelbuddy.base.navigation.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shacklehotelbuddy.base.navigation.NavigatorWays
import com.example.shacklehotelbuddy.features.hotels.ui.HotelsScreen
import com.example.shacklehotelbuddy.features.search.ui.SearchScreen

/**
 * Init navigation host and show default screen.
 */
@Composable
fun InitNavHostAndShowDefault() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = NavigatorWays.SEARCH
    ) {
        composable(NavigatorWays.SEARCH) { SearchScreen(navController) }
        composable(NavigatorWays.HOTEL_LIST) { HotelsScreen(navController) }
    }
}