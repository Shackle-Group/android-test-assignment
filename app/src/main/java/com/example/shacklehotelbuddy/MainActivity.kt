package com.example.shacklehotelbuddy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.ui.screens.HotelsListScreen
import com.example.shacklehotelbuddy.ui.screens.SearchHotelScreen
import com.example.shacklehotelbuddy.ui.view_model.HotelViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShackleHotelBuddyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    val viewModel : HotelViewModel = hiltViewModel()
                    NavHost(
                        navController = navController,
                        startDestination = "search_hotel"
                    ) {
                        composable("search_hotel") {
                            SearchHotelScreen(navController, viewModel)
                        }
                        composable("hotels_list") {
                            HotelsListScreen(navController, viewModel)

                        }
                    }
                }
            }
        }
    }
}