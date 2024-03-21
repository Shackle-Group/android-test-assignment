package com.example.shacklehotelbuddy.features.search.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.features.search.ui.dialogs.InputNumberDialog
import com.example.shacklehotelbuddy.features.search.viewModels.SearchViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

@Composable
fun SearchScreen(
    navController: NavController? = null,
    searchViewModel: SearchViewModel = hiltViewModel()
) {
    InputNumberDialog(
        value = "Hello",
        setShowDialog = {},
        setValue = {}
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
                modifier = Modifier.padding(16.dp).fillMaxSize()
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

                    RecentSearches(searchViewModel = searchViewModel)
                }

                SearchButton {

                }
            }
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