package com.adrianczuczka.search.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adrianczuczka.search.R
import com.adrianczuczka.ui.theme.ShackleHotelBuddyTheme
import java.util.Calendar
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CheckInDateRow(
    showDatePicker: Boolean,
    onDateChanged: (dateMillis: Long) -> Unit,
    onDismiss: () -> Unit,
    onDateButtonClick: () -> Unit,
    selectedDate: Date?,
) {
    Row(
        modifier = Modifier
            .padding(top = 32.dp)
            .height(IntrinsicSize.Max)
            .clip(RoundedCornerShape(16.dp, 16.dp, 0.dp, 0.dp))
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.event_upcoming),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.search_screen_check_in_date_text),
                style = ShackleHotelBuddyTheme
                    .typography
                    .bodyMedium
                    .copy(
                        color = ShackleHotelBuddyTheme.colors.grayText
                    ),
                modifier = Modifier.padding(start = 8.dp)
            )
        }
        Divider(
            modifier = Modifier
                .fillMaxHeight()
                .width(1.dp)
                .background(ShackleHotelBuddyTheme.colors.grayBorder)
        )
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable {
                    onDateButtonClick()
                }
                .padding(16.dp)
                .weight(1f)
        ) {
            val text = if (selectedDate != null) {
                val calendar = Calendar.getInstance()
                calendar.time = selectedDate
                stringResource(
                    id = R.string.search_screen_date_label,
                    calendar[Calendar.DAY_OF_WEEK],
                    calendar[Calendar.MONTH],
                    calendar[Calendar.YEAR]
                )
            } else {
                stringResource(id = R.string.search_screen_default_date_label)
            }
            Text(
                text = text,
                style = ShackleHotelBuddyTheme
                    .typography
                    .bodyMedium
                    .copy(
                        color = ShackleHotelBuddyTheme.colors.grayText
                    )
            )
        }
    }
    if (showDatePicker) {
        val datePickerState = rememberDatePickerState()
        DatePickerDialog(
            shape = RoundedCornerShape(6.dp),
            onDismissRequest = {
                onDismiss()
            },
            confirmButton = {
                Button(
                    onClick = {
                        val dateMillis = datePickerState.selectedDateMillis
                        if (dateMillis != null) {
                            onDateChanged(dateMillis)
                        }
                    },
                    enabled = datePickerState.selectedDateMillis != null
                ) {
                    Text(text = stringResource(id = R.string.search_screen_date_picker_confirm_button_text))
                }
            },
        ) {
            DatePicker(
                state = datePickerState,
            )
        }
    }
}