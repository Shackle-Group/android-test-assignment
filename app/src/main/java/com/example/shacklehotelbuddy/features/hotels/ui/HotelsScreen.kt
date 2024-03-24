package com.example.shacklehotelbuddy.features.hotels.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsAction
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsIntent
import com.example.shacklehotelbuddy.features.hotels.mvi.HotelsState
import com.example.shacklehotelbuddy.features.hotels.viewModels.HotelsViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.utils.InitDisposableSubscriptionEffect
import kotlinx.coroutines.launch

/**
 * Hotels screen.
 *
 * @param navController Navigation controller
 * @param hotelsViewModel Hotels view model
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HotelsScreen(
    navController: NavController? = null,
    hotelsViewModel: HotelsViewModel = hiltViewModel()
) {
    val uiState: HotelsState by hotelsViewModel.state.collectAsStateWithLifecycle()

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    hotelsViewModel.InitDisposableSubscriptionEffect(
        onStartCallback = { hotelsViewModel.dispatchIntentAsync(HotelsIntent.LoadHotels) },
        mviSingleActionCallback = { singleAction ->
            when (singleAction) {
                is HotelsAction.OpenHotelDetails -> scope.launch {
                    snackbarHostState.showSnackbar(
                        "You tapped by ${singleAction.hotelId}. This feature is not implemented."
                    )
                }

                is HotelsAction.ShowError -> scope.launch {
                    // Error message as just printed here, but it can be localized to another languages.
                    snackbarHostState.showSnackbar(singleAction.message)
                }
            }
        }
    )

    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier = Modifier.fillMaxSize().padding(end = 48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = stringResource(id = R.string.hotels_title),
                            style = ShackleHotelBuddyTheme.typography.bodyBold,
                            color = ShackleHotelBuddyTheme.colors.black,
                            textAlign = TextAlign.Center,
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = { navController?.popBackStack() }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = null)
                    }
                },
            )
        },
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
                .background(ShackleHotelBuddyTheme.colors.white),
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                LazyColumn {
                    if (uiState.isLoading) {
                        // Show loading animation.
                        items(count = 3) {
                            LoadingAnimationItem()
                        }
                    } else if (uiState.hotels.isEmpty()) {
                        item {
                            Text(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .align(Alignment.CenterHorizontally)
                                    .padding(top = 120.dp),
                                text = stringResource(id = R.string.hotels_empty_list),
                                style = ShackleHotelBuddyTheme.typography.bodyMedium.copy(
                                    textAlign = TextAlign.Center
                                ),
                                color = ShackleHotelBuddyTheme.colors.grayText
                            )
                        }
                    } else {
                        // Show hotels.
                        items(count = uiState.hotels.size) { index ->
                            HotelItem(hotel = uiState.hotels[index]) {
                                hotelsViewModel.dispatchIntentAsync(HotelsIntent.TapToHotel(uiState.hotels[index].id))
                            }
                        }
                    }
                }
            }
        }
    }
}