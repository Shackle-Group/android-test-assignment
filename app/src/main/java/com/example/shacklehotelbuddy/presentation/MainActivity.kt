package com.example.shacklehotelbuddy.presentation

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.shacklehotelbuddy.core_utils.designs.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.core_utils.navigation.Routes
import com.example.shacklehotelbuddy.core_utils.navigation.UiEvent
import com.example.shacklehotelbuddy.features_home.presentation.PropertyVm
import com.example.shacklehotelbuddy.features_home.presentation.SearchPage
import com.example.shacklehotelbuddy.features_home.presentation.SearchResultPage
import com.example.shacklehotelbuddy.features_splash.SplashPage
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            ShackleHotelBuddyTheme {
                val systemUiController = rememberSystemUiController()
                val userDarkIcons = isSystemInDarkTheme()
                val context = LocalContext.current

                SideEffect {
                    systemUiController.setSystemBarsColor(
                        color = Color.Transparent, darkIcons = userDarkIcons
                    )
                    systemUiController.setStatusBarColor(if (userDarkIcons) Color.White else Color.Black)
                    systemUiController.setNavigationBarColor(if (userDarkIcons) Color.White else Color.Black)
                }

                val navController = rememberNavController()

                val propertyVm: PropertyVm = hiltViewModel()

                Surface(color = MaterialTheme.colorScheme.background) {
                    NavHost(navController = navController, startDestination = Routes.splashPage) {
                        composable(Routes.splashPage) {
                            SplashPage { event ->
                                if (event is UiEvent.OnNavigate) {
                                    navController.navigate(event.route) {
                                        popUpTo(0)
                                    }
                                }
                            }
                        }

                        composable(Routes.searchPage) {
                            SearchPage(
                                propertyVm = propertyVm,
                                onNavigate = { event ->
                                    if (event is UiEvent.OnNavigate) {
                                       navController.navigate(event.route)
                                    }
                                }
                            )
                        }

                        composable(Routes.searchResultsPage) {
                            SearchResultPage(
                                propertyVm = propertyVm,
                                navController = navController
                            )
                        }


                    }
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = com.example.shacklehotelbuddy.core_resources.R.drawable.background),
                contentScale = ContentScale.FillWidth
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .border(width = 2.dp, color = MaterialTheme.colorScheme.background)
                .background(Color.White)
                .padding(16.dp)
        ) {
            Text(
                text = "Hello!",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSecondary
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShackleHotelBuddyTheme {
        MainScreen()
    }
}