package com.example.shacklehotelbuddy.features.search.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.mvi.SearchState
import com.example.shacklehotelbuddy.features.search.viewModels.SearchViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Recent searches.
 *
 * @param searchViewModel Search view model
 */
@Composable
fun RecentSearches(searchViewModel: SearchViewModel = hiltViewModel()) {
    val uiState: SearchState by searchViewModel.state.collectAsStateWithLifecycle()
    val dateFormat by remember {
        mutableStateOf(SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()))
    }
    Text(
        text = stringResource(id = R.string.search_recent_searches),
        style = ShackleHotelBuddyTheme.typography.bodyLarge,
        color = ShackleHotelBuddyTheme.colors.white,
        modifier = Modifier.padding(bottom = 16.dp, top = 24.dp),
        textAlign = TextAlign.Start
    )

    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = ShackleHotelBuddyTheme.colors.white)
    ) {
        LazyColumn {
            items(uiState.lastActualSearches.size) {
                val item = uiState.lastActualSearches[it]
                ResentSearchesItem(
                    timeRange = "${dateFormat.format(item.checkInTimestamp)} - ${dateFormat.format(item.checkOutTimestamp)}",
                    countsLine = stringResource(id = R.string.search_recent_item_content, item.adultCount, item.childrenCount),
                    isLast = it == uiState.lastActualSearches.size - 1,
                    actionByIcon = {
                        searchViewModel.dispatchIntentAsync(
                            SearchIntent.RemainSearchParameters(item)
                        )
                    },
                    actionByDate = {
                        searchViewModel.dispatchIntentAsync(
                            SearchIntent.RepeatSearch(item)
                        )
                    },
                )
            }
        }
    }
}