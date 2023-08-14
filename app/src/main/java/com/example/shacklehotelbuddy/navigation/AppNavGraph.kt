package com.example.shacklehotelbuddy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.adrianczuczka.features.properties.PropertiesScreen
import com.adrianczuczka.features.search.SearchScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "search"
    ) {

        composable("search") {
            SearchScreen(
                navController = navController
            )
        }

        composable(
            "list/{checkInDate}/{checkOutDate}/{adultsCount}/{childrenCount}",
            arguments = listOf(
                navArgument("checkInDate") { type = NavType.LongType },
                navArgument("checkOutDate") { type = NavType.LongType },
                navArgument("adultsCount") { type = NavType.IntType },
                navArgument("childrenCount") { type = NavType.IntType }
            )
        ) {
            PropertiesScreen()
        }
    }
}