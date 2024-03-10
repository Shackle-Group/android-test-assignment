package com.example.shacklehotelbuddy.presentation.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shacklehotelbuddy.BuildConfig
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.presentation.ui.views.HotelListScreen
import com.example.shacklehotelbuddy.presentation.ui.views.MainSearchScreen
import com.example.shacklehotelbuddy.presentation.utils.Destination
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        plantTimber()
        setContent {
            ShackleHotelBuddyTheme {
                val navController = rememberNavController()
                val viewModel: MainViewModel = hiltViewModel()
                NavHost(
                    navController = navController,
                    startDestination = Destination.MainSearchScreen.route
                ) {
                    composable(route = Destination.MainSearchScreen.route) {
                        MainSearchScreen(viewModel, navController)
                    }
                    composable(route = Destination.HotelListScreen.route) {
                        HotelListScreen(viewModel, navController)
                    }
                }
            }
        }
    }

    private fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ShackleHotelBuddyTheme {
//        MainSearchScreen(MainViewModel(), rememberNavController())
//    }
//}