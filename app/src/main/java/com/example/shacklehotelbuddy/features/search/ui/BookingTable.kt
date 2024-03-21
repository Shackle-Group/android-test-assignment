package com.example.shacklehotelbuddy.features.search.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.viewModels.SearchViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

@Composable
fun BookingTable(searchViewModel: SearchViewModel = hiltViewModel()) {
//    DatePickerDialoga(
//        onDateSelected = {
////                    searchViewModel.dispatchIntentAsync(SearchIntent.CheckInDateSelected(it))
//        },
//        onDismiss = {
////                    searchViewModel.dispatchIntentAsync(SearchIntent.DatePickerDismissed)
//        }
//    )

    Card(
        modifier = Modifier
            .clip(shape = RoundedCornerShape(16.dp))
            .fillMaxWidth()
            .wrapContentHeight(),
        colors = CardDefaults.cardColors(containerColor = ShackleHotelBuddyTheme.colors.white)
    ) {
        BookingSearchItem(
            iconRes = R.drawable.event_upcoming,
            titleRes = R.string.search_check_in,
            value = "DD / MM / YYYY"
        ) {

//            searchViewModel.dispatchIntentAsync(SearchIntent.CheckInDateClicked)
        }
        BookingSearchItem(
            iconRes = R.drawable.event_available,
            titleRes = R.string.search_check_out,
            value = "DD / MM / YYYY"
        ) {
            searchViewModel.dispatchIntentAsync(SearchIntent.CheckOutDateClicked)
        }
        BookingSearchItem(
            iconRes = R.drawable.person,
            titleRes = R.string.search_adult_counter,
            value = "1"
        ) {
            searchViewModel.dispatchIntentAsync(SearchIntent.CheckInDateClicked)
        }
        BookingSearchItem(
            iconRes = R.drawable.supervisor_account,
            titleRes = R.string.search_child_counter,
            value = "0",
            isLast = true
        ) {
            searchViewModel.dispatchIntentAsync(SearchIntent.CheckInDateClicked)
        }
    }
}