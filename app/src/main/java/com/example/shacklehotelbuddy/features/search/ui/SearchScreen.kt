package com.example.shacklehotelbuddy.features.search.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.base.navigation.NavigatorWays
import com.example.shacklehotelbuddy.features.search.mvi.SearchAction
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.mvi.SearchState
import com.example.shacklehotelbuddy.features.search.viewModels.SearchViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.utils.InitDisposableSubscriptionEffect

/**
 * Search screen.
 *
 * @param navController Nav controller
 * @param searchViewModel Search view model
 */
@Composable
fun SearchScreen(
    navController: NavController? = null,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    val uiState: SearchState by searchViewModel.state.collectAsStateWithLifecycle()

    searchViewModel.InitDisposableSubscriptionEffect(
        onStartCallback = { searchViewModel.dispatchIntentAsync(SearchIntent.LoadDefaultContent) },
        mviSingleActionCallback = { singleAction ->
            when (singleAction) {
                SearchAction.ShowHotels -> navController?.navigate(NavigatorWays.HOTEL_LIST)
            }
        }
    )
    Scaffold { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = paddingValues.calculateTopPadding())
                .paint(
                    painterResource(id = R.drawable.background),
                    contentScale = ContentScale.FillWidth
                ),
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxSize()
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceAround,
                ) {
                    Text(
                        text = stringResource(id = R.string.search_title),
                        style = ShackleHotelBuddyTheme.typography.titleBig,
                        textAlign = TextAlign.Start,
                        color = ShackleHotelBuddyTheme.colors.white,
                        modifier = Modifier.padding(top = 142.dp, bottom = 30.dp)
                    )

                    BookingTable(searchViewModel = searchViewModel)

                    if (uiState.lastActualSearches.isNotEmpty()) {
                        RecentSearches(searchViewModel = searchViewModel)
                    }
                }

                SearchButton {
                    searchViewModel.dispatchIntentAsync(SearchIntent.MakeSearch)
                }
            }
        }
    }
}