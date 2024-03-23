package com.example.shacklehotelbuddy.features.search.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.features.search.mvi.SearchIntent
import com.example.shacklehotelbuddy.features.search.mvi.SearchState
import com.example.shacklehotelbuddy.features.search.ui.dialogs.checkDatePickerDialog
import com.example.shacklehotelbuddy.features.search.ui.dialogs.inputNumberDialog
import com.example.shacklehotelbuddy.features.search.viewModels.SearchViewModel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme
import java.text.SimpleDateFormat
import java.util.Locale

/**
 * Booking table.
 *
 * @param searchViewModel Search view model
 */
@Composable
fun BookingTable(searchViewModel: SearchViewModel = hiltViewModel()) {
    val uiState: SearchState by searchViewModel.state.collectAsStateWithLifecycle()
    val dateFormat by remember {
        mutableStateOf(SimpleDateFormat("dd/MM/yyyy", Locale.getDefault()))
    }
    // Check and open dialog if need.
    val checkInDialogState = checkDatePickerDialog(
        timeRange = System.currentTimeMillis()..Long.MAX_VALUE,
        onDateSelected = {
            searchViewModel.dispatchIntentAsync(
                SearchIntent.UpdateCheckInDate(
                    timestamp = it
                )
            )
        }
    )
    val checkOutDialogState = checkDatePickerDialog(
        timeRange = uiState.checkInTimestamp..Long.MAX_VALUE,
        onDateSelected = {
            searchViewModel.dispatchIntentAsync(
                SearchIntent.UpdateCheckOutDate(
                    timestamp = it
                )
            )
        }
    )
    val adults = inputNumberDialog(
        initValue = uiState.adultCount,
        minLimit = 1,
        onConfirmation = {
            searchViewModel.dispatchIntentAsync(
                SearchIntent.UpdateAdults(
                    count = it
                )
            )
        }
    )
    val children = inputNumberDialog(
        initValue = uiState.childrenCount,
        onConfirmation = {
            searchViewModel.dispatchIntentAsync(
                SearchIntent.UpdateChildren(
                    count = it
                )
            )
        }
    )
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
            value = dateFormat.format(uiState.checkInTimestamp)
        ) {
            checkInDialogState.value = true
        }
        BookingSearchItem(
            iconRes = R.drawable.event_available,
            titleRes = R.string.search_check_out,
            value = dateFormat.format(uiState.checkOutTimestamp)
        ) {
            checkOutDialogState.value = true
        }
        BookingSearchItem(
            iconRes = R.drawable.person,
            titleRes = R.string.search_adult_counter,
            value = uiState.adultCount.toString()
        ) {
            adults.value = true
        }
        BookingSearchItem(
            iconRes = R.drawable.supervisor_account,
            titleRes = R.string.search_child_counter,
            value = uiState.childrenCount.toString(),
            isLast = true
        ) {
            children.value = true
        }
    }
}