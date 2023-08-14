package com.adrianczuczka.features.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.adrianczuczka.common.ui.theme.ShackleHotelBuddyTheme
import com.adrianczuczka.features.search.content.AdultsCountRow
import com.adrianczuczka.features.search.content.CheckInDateRow
import com.adrianczuczka.features.search.content.CheckOutDateRow
import com.adrianczuczka.features.search.content.ChildrenCountRow
import com.adrianczuczka.features.search.content.SearchRow
import com.adrianczuczka.features.search.state.SearchState
import com.adrianczuczka.features.search.viewmodel.SearchViewModel

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
    navController: NavController,
) {
    LaunchedEffect(Unit) {
        viewModel.loadRecentSearches()
    }
    val state = viewModel.state.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillWidth
            )
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .weight(1f)
                .padding(horizontal = 16.dp),
        ) {
            item {
                Text(
                    text = stringResource(id = R.string.search_screen_title_text),
                    style = ShackleHotelBuddyTheme.typography.title,
                    color = Color.White
                )
            }
            item {
                CheckInDateRow(
                    showDatePicker = state.datePickerState == SearchState.DatePickerState.CHECK_IN,
                    onDateChanged = { viewModel.onCheckInDateChanged(it) },
                    onDismiss = { viewModel.dismissDatePicker() },
                    onDateButtonClick = { viewModel.onCheckInButtonClick() },
                    selectedDate = state.checkInDate
                )
            }
            item {
                Divider()
            }
            item {
                CheckOutDateRow(
                    showDatePicker = state.datePickerState == SearchState.DatePickerState.CHECK_OUT,
                    onDateChanged = { viewModel.onCheckOutDateChanged(it) },
                    onDismiss = { viewModel.dismissDatePicker() },
                    onDateButtonClick = { viewModel.onCheckOutButtonClick() },
                    selectedDate = state.checkOutDate
                )
            }
            item {
                Divider()
            }
            item {
                AdultsCountRow(
                    adultCount = state.adultCount,
                    onCountChange = { viewModel.onAdultCountChanged(it) })
            }
            item {
                Divider()
            }
            item {
                ChildrenCountRow(
                    childrenCount = state.childrenCount,
                    onCountChange = { viewModel.onChildrenCountChanged(it) }
                )
            }
            if (state.mostRecentSearches.isNotEmpty()) {
                item {
                    Text(
                        text = stringResource(id = R.string.search_screen_recent_searches_title_text),
                        style = ShackleHotelBuddyTheme
                            .typography
                            .titleSmall
                            .copy(
                                color = ShackleHotelBuddyTheme.colors.white
                            ),
                        modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
                    )
                }
                items(state.mostRecentSearches) { search ->
                    SearchRow(
                        searchInfo = search,
                        onClick = {
                            navController.navigate("list/${search.checkInDate.time}/${search.checkOutDate.time}/${search.adultCount}/${search.childrenCount}")
                        }
                    )
                }
            }
        }
        Button(
            onClick = {
                if (state.checkInDate != null && state.checkOutDate != null) {
                    viewModel.storeSearch(
                        state.checkInDate,
                        state.checkOutDate,
                        state.adultCount,
                        state.childrenCount
                    )
                    navController.navigate("list/${state.checkInDate.time}/${state.checkOutDate.time}/${state.adultCount}/${state.childrenCount}")
                }
            },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 40.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = ShackleHotelBuddyTheme.colors.teal,
                disabledContainerColor = Color.DarkGray
            ),
            enabled = state.checkInDate != null && state.checkOutDate != null
        ) {
            Text(
                text = stringResource(id = R.string.search_screen_search_button_text),
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
                fontSize = 18.sp
            )
        }
    }
}