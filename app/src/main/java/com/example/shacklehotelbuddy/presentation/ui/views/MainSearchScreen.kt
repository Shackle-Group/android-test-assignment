package com.example.shacklehotelbuddy.presentation.ui.views

import android.app.DatePickerDialog
import android.widget.DatePicker
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import com.example.shacklehotelbuddy.domain.model.SearchDate
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.presentation.ui.main.MainViewModel
import com.example.shacklehotelbuddy.presentation.utils.Destination
import com.example.shacklehotelbuddy.presentation.utils.parseSearchUiError
import java.util.Calendar

@Composable
fun MainSearchScreen(viewModel: MainViewModel, navController: NavHostController) {

    val hotelSearch by viewModel.hotelSearch.collectAsState()
    val cachedSearchList by viewModel.cachedSearchList.collectAsState()

    val context = LocalContext.current

    Box(
        modifier = Modifier
            .fillMaxSize()
            .paint(
                painterResource(id = R.drawable.background), contentScale = ContentScale.FillWidth
            )
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.select_guests_date_time),
                style = ShackleHotelBuddyTheme.typography.titleLarge,
                textAlign = TextAlign.Start,
                color = ShackleHotelBuddyTheme.colors.white,
                modifier = Modifier.padding(top = 32.dp, bottom = 16.dp)
            )

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                colors = CardDefaults.cardColors(containerColor = Color.White),
            ) {
                Column {

                    CheckInDate(hotelSearch.checkInDate) { day: Int, month: Int, year: Int ->
                        viewModel.updateCheckInDate(day, month, year)
                    }
                    Divider()

                    CheckOutDate(hotelSearch.checkOutDate) { day: Int, month: Int, year: Int ->
                        viewModel.updateCheckOutDate(day, month, year)
                    }

                    Divider()

                    Adults(
                        hotelSearch.adults,
                        { viewModel.updateAdults(it) },
                        { viewModel.updateAdults(it) }
                    )

                    Divider()

                    Children(
                        hotelSearch.children,
                        { viewModel.updateChildren(it) },
                        { viewModel.updateChildren(it) }
                    )
                }
            }

            Text(
                text = stringResource(id = R.string.recent_searches),
                style = ShackleHotelBuddyTheme.typography.bodyLarge,
                color = ShackleHotelBuddyTheme.colors.white,
                modifier = Modifier.padding(bottom = 8.dp, top = 24.dp),
                textAlign = TextAlign.Start
            )

            RecentSearchList(cachedSearchList) { hotelSearch ->
                viewModel.searchHistory(hotelSearch)
                navController.navigate(Destination.HotelListScreen.route)
            }

            Spacer(modifier = Modifier.size(5.dp))

            SearchButton {
                val error = viewModel.getSearchValidationError()
                if (error == null) {
                    viewModel.searchHotels()
                    navController.navigate(Destination.HotelListScreen.route)
                } else {
                    Toast.makeText(
                        context,
                        context.getString(error.parseSearchUiError()),
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}

@Composable
fun SearchButton(startHotelSearch: () -> Unit) {

    Button(
        colors = ButtonDefaults.buttonColors(containerColor = ShackleHotelBuddyTheme.colors.teal),
        shape = RoundedCornerShape(20.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp),
        onClick = { startHotelSearch() }
    ) {
        Text(
            text = stringResource(id = R.string.search),
            style = ShackleHotelBuddyTheme.typography.buttonMedium
        )
    }
}

@Composable
fun RecentSearchList(
    cachedSearchList: List<HotelSearch>,
    recentSearchSelected: (HotelSearch) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(5.dp)
    ) {
        items(cachedSearchList) {
            SearchHistoryItem(it) {
                recentSearchSelected(it)
            }
        }
    }
}

@Composable
fun SearchHistoryItem(
    hotelSearch: HotelSearch,
    searchHistory: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(ShackleHotelBuddyTheme.colors.white)
            .clickable { searchHistory() }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.manage_history),
            tint = ShackleHotelBuddyTheme.colors.teal,
            contentDescription = stringResource(id = R.string.icon_recent_search),
            modifier = Modifier
                .padding(8.dp)
                .height(30.dp)
                .width(40.dp)
        )
        Divider(
            modifier = Modifier
                .height(50.dp)
                .width(1.dp)
        )
        Text(
            text = "${hotelSearch.checkInDate} to ${hotelSearch.checkOutDate} for ${hotelSearch.adults} ${
                (if (hotelSearch.adults > 1) "adults" else "adult")
            } ${
                if (hotelSearch.children == 1) "& ${hotelSearch.children} child"
                else if (hotelSearch.children > 1) "& ${hotelSearch.children} children"
                else ""
            }",
            textAlign = TextAlign.Start,
            style = ShackleHotelBuddyTheme.typography.bodySmall,
            modifier = Modifier
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.size(5.dp))
    }
}

@Composable
fun CheckInDate(
    checkInDate: SearchDate,
    updateCheckInDate: (Int, Int, Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth()
            .height(52.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.event_upcoming),
                contentDescription = stringResource(id = R.string.check_in_date)
            )
            Text(
                text = stringResource(id = R.string.check_in_date),
                style = ShackleHotelBuddyTheme.typography.bodyMedium,
                color = ShackleHotelBuddyTheme.colors.grayText,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Divider(
            modifier = Modifier
                .height(50.dp)
                .width(1.dp)
        )

        val calendar = Calendar.getInstance()
//        ADD ON: set max date if user selected/updated checkout date
//        viewModel.getUserSelectedDate(currentCheckInDate.value.checkInDate)?.let {
//            calendar.timeInMillis = it
//        }
        val datePickerDialog = DatePickerDialog(
            LocalContext.current,
            { _: DatePicker, year: Int, month: Int, day: Int ->
                updateCheckInDate(day, month + 1, year)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        datePickerDialog.datePicker.minDate = Calendar.getInstance().timeInMillis

        Text(
            text = checkInDate.toString(),
            style = ShackleHotelBuddyTheme.typography.bodyMediumCentral,
            textAlign = TextAlign.Center,
            color = ShackleHotelBuddyTheme.colors.grayText,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    datePickerDialog.show()
                }
        )
    }
}

@Composable
fun CheckOutDate(
    checkOutDate: SearchDate,
    updateCheckOutDate: (Int, Int, Int) -> Unit
) {
    Row(
        modifier = Modifier
            .padding(start = 12.dp)
            .fillMaxWidth()
            .height(52.dp)
            .background(ShackleHotelBuddyTheme.colors.white),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .height(50.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.event_available),
                contentDescription = stringResource(id = R.string.check_out_date)
            )
            Text(
                text = stringResource(id = R.string.check_out_date),
                style = ShackleHotelBuddyTheme.typography.bodyMedium,
                color = ShackleHotelBuddyTheme.colors.grayText,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Divider(
            modifier = Modifier
                .height(50.dp)
                .width(1.dp)
        )

        val calendar = Calendar.getInstance()
        // select user set date in picker
//        viewModel.getUserSelectedDate(currentCheckOutDate)?.let {
//            calendar.timeInMillis = it
//        }
        val datePickerDialog = DatePickerDialog(
            LocalContext.current,
            { _: DatePicker, year: Int, month: Int, dayOfMonth: Int ->
                updateCheckOutDate(dayOfMonth, month + 1, year)
            },
            calendar.get(Calendar.YEAR),
            calendar.get(Calendar.MONTH),
            calendar.get(Calendar.DAY_OF_MONTH)
        )
        // limit user dates in case user has selected check in date
//        viewModel.getUserSelectedDate(currentCheckInDate.value)?.let {
//            datePickerDialog.datePicker.minDate = it
//        }
        datePickerDialog.datePicker.minDate = calendar.timeInMillis

        Text(
            text = checkOutDate.toString(),
            style = ShackleHotelBuddyTheme.typography.bodyMediumCentral,
            textAlign = TextAlign.Center,
            color = ShackleHotelBuddyTheme.colors.grayText,
            modifier = Modifier
                .weight(1f)
                .clickable {
                    datePickerDialog.show()
                }
        )
    }
}

@Composable
fun Adults(
    adults: Int,
    updateAdults: (String) -> Unit,
    updateAdultsByIncrement: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.padding(start = 12.dp).fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .height(52.dp)
                .background(ShackleHotelBuddyTheme.colors.white)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.person),
                contentDescription = stringResource(id = R.string.adults)
            )
            Text(
                text = stringResource(id = R.string.adults),
                style = ShackleHotelBuddyTheme.typography.bodyMedium,
                color = ShackleHotelBuddyTheme.colors.grayText,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Divider(
            modifier = Modifier
                .height(52.dp)
                .width(1.dp)
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .height(52.dp)
                .background(ShackleHotelBuddyTheme.colors.white)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.minus),
                contentDescription = stringResource(id = R.string.icon_minus),
                modifier = Modifier
                    .height(52.dp)
                    .weight(0.5f)
                    .clickable { updateAdultsByIncrement(false) }
            )
            BasicTextField(
                value = adults.toString(),
                onValueChange = { updateAdults(it) },
                textStyle = ShackleHotelBuddyTheme.typography.bodyMediumCentral,
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = stringResource(id = R.string.icon_plus),
                modifier = Modifier
                    .height(52.dp)
                    .weight(0.5f)
                    .clickable { updateAdultsByIncrement(true) }
            )
        }
    }
}

@Composable
fun Children(
    children: Int,
    updateChildren: (String) -> Unit,
    updateChildrenByIncrement: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.padding(start = 12.dp).fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .height(52.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            Icon(
                painter = painterResource(id = R.drawable.supervisor_account),
                contentDescription = stringResource(id = R.string.children)
            )
            Text(
                text = stringResource(id = R.string.children),
                style = ShackleHotelBuddyTheme.typography.bodyMedium,
                color = ShackleHotelBuddyTheme.colors.grayText,
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Divider(
            modifier = Modifier
                .height(52.dp)
                .width(1.dp)
        )
        Row(
            modifier = Modifier
                .weight(1f)
                .height(52.dp)
                .padding(8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
//            val currentChildCount = viewModel.currentChildCount.collectAsState()
            Icon(
                painter = painterResource(id = R.drawable.minus),
                contentDescription = stringResource(id = R.string.icon_minus),
                modifier = Modifier
                    .height(52.dp)
                    .weight(0.5f)
                    .clickable { updateChildrenByIncrement(false) }
            )
            BasicTextField(
                value = children.toString(),
                onValueChange = { updateChildren(it) },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                textStyle = ShackleHotelBuddyTheme.typography.bodyMediumCentral,
                singleLine = true,
                modifier = Modifier.weight(1f)
            )
            Icon(
                painter = painterResource(id = R.drawable.plus),
                contentDescription = stringResource(id = R.string.icon_plus),
                modifier = Modifier
                    .height(52.dp)
                    .weight(0.5f)
                    .clickable { updateChildrenByIncrement(true) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ShackleHotelBuddyTheme {
        MainSearchScreen(hiltViewModel(), rememberNavController())
    }
}