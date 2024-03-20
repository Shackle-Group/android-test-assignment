package com.example.shacklehotelbuddy.features.search.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.base.navigation.NavigatorWays
import com.example.shacklehotelbuddy.features.search.viewModels.SearchViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

@Composable
fun SearchScreen(
    navController: NavController? = null,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillWidth
            ),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .border(width = 2.dp, color = ShackleHotelBuddyTheme.colors.grayBorder)
                .background(ShackleHotelBuddyTheme.colors.white)
                .padding(16.dp)
        ) {
            Text(
                text = "Search screen",
                style = ShackleHotelBuddyTheme.typography.bodyMedium,
                color = ShackleHotelBuddyTheme.colors.grayText,
                modifier = Modifier
                    .clickable {
                        navController?.navigate(NavigatorWays.HOTEL_LIST)
                    }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShackleHotelBuddyTheme {
        SearchScreen()
    }
}