package com.adrianczuczka.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.adrianczuczka.search.content.SearchParamsGrid
import com.adrianczuczka.search.viewmodel.SearchViewModel
import com.adrianczuczka.ui.theme.ShackleHotelBuddyTheme

@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel(),
) {
    val state = viewModel.state.collectAsState().value
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .paint(
                painter = painterResource(id = R.drawable.background),
                contentScale = ContentScale.FillWidth
            )
    ) {
        SearchParamsGrid(
            adultCount = state.adultCount,
            onAdultCountChanged = { viewModel.onAdultCountChanged(it) },
            childrenCount = state.childrenCount,
            onChildrenCountChanged = { viewModel.onChildrenCountChanged(it) },
            datePickerState = state.datePickerState,
            onDismissDatePicker = { viewModel.dismissDatePicker() },
            onCheckInDateChanged = { viewModel.onCheckInDateChanged(it) },
            onCheckOutDateChanged = { viewModel.onCheckOutDateChanged(it) },
            onCheckInDateButtonClick = { viewModel.onCheckInButtonClick() },
            onCheckOutDateButtonClick = { viewModel.onCheckOutButtonClick() },
            selectedCheckInDate = state.checkInDate,
            selectedCheckOutDate = state.checkOutDate
        )
        Button(
            onClick = {
                // TODO: Implement search
            },
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 40.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = ShackleHotelBuddyTheme.colors.teal)
        ) {
            Text(
                text = stringResource(id = R.string.search_screen_search_button_text),
                modifier = Modifier.padding(vertical = 16.dp, horizontal = 32.dp),
                fontSize = 18.sp
            )
        }
    }
}