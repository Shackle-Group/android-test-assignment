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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.features.search.viewModels.SearchViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

@Composable
fun RecentSearches(searchViewModel: SearchViewModel = hiltViewModel()) {
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
            items(3) {
                ResentSearchesItem(
                    timeRange = "03/07/2024 - 15/07/2024",
                    isLast = it == 2,
                    actionByIcon = {},
                    actionByDate = {},
                )
            }
        }
    }
}