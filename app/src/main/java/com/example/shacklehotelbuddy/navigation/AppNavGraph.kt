package com.example.shacklehotelbuddy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.adrianczuczka.search.SearchScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = "search"
    ) {

        composable("search") {
            SearchScreen()
        }

        composable(
            "list/{checkInDate}/{checkOutDate}/{adultsCount}/{childrenCount}",
            arguments = listOf(
                navArgument("checkInDate") { type = NavType.LongType },
                navArgument("checkOutDate") { type = NavType.LongType },
                navArgument("adultsCount") { type = NavType.IntType },
                navArgument("childrenCount") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val checkInDate = backStackEntry.arguments?.getLong("checkInDate")
            val checkOutDate = backStackEntry.arguments?.getLong("checkOutDate")
            val adultsCount = backStackEntry.arguments?.getInt("adultsCount")
            val childrenCount = backStackEntry.arguments?.getInt("childrenCount")

            Profile(navController, userId, username, address)
        }
    }
}