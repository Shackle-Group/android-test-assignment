package com.adrianczuczka.search.content

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adrianczuczka.search.R
import com.adrianczuczka.search.state.SearchState
import com.adrianczuczka.ui.theme.ShackleHotelBuddyTheme
import java.util.Date

@Composable
fun ColumnScope.SearchParamsGrid(
    adultCount: Int,
    onAdultCountChanged: (count: Int) -> Unit,
    childrenCount: Int,
    onChildrenCountChanged: (count: Int) -> Unit,
    datePickerState: SearchState.DatePickerState?,
    onDismissDatePicker: () -> Unit,
    onCheckInDateChanged: (dateMillis: Long) -> Unit,
    onCheckOutDateChanged: (dateMillis: Long) -> Unit,
    onCheckInDateButtonClick: () -> Unit,
    onCheckOutDateButtonClick: () -> Unit,
    selectedCheckInDate: Date?,
    selectedCheckOutDate: Date?,
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
                showDatePicker = datePickerState == SearchState.DatePickerState.CHECK_IN,
                onDateChanged = onCheckInDateChanged,
                onDismiss = onDismissDatePicker,
                onDateButtonClick = onCheckInDateButtonClick,
                selectedDate = selectedCheckInDate
            )
        }
        item {
            Divider()
        }
        item {
            CheckOutDateRow(
                showDatePicker = datePickerState == SearchState.DatePickerState.CHECK_OUT,
                onDateChanged = onCheckOutDateChanged,
                onDismiss = onDismissDatePicker,
                onDateButtonClick = onCheckOutDateButtonClick,
                selectedDate = selectedCheckOutDate
            )
        }
        item {
            Divider()
        }
        item {
            AdultsCountRow(adultCount = adultCount, onCountChange = onAdultCountChanged)
        }
        item {
            Divider()
        }
        item {
            ChildrenCountRow(childrenCount = childrenCount, onCountChange = onChildrenCountChanged)
        }
    }
}