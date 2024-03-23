package com.example.shacklehotelbuddy.features.search.ui.dialogs

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

/**
 * Check date picker dialog.
 *
 * @param timeRange Time range
 * @param onDateSelected On date selected
 * @return Flow to control visibility of dialog
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun checkDatePickerDialog(
    timeRange: LongRange,
    onDateSelected: (Long) -> Unit,
): MutableState<Boolean> {
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
            override fun isSelectableDate(utcTimeMillis: Long): Boolean {
                return utcTimeMillis in timeRange
            }
        })

        DatePickerDialog(
            onDismissRequest = { showDialog.value = false },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = ShackleHotelBuddyTheme.colors.teal),
                    onClick = {
                        onDateSelected(datePickerState.selectedDateMillis ?: System.currentTimeMillis())
                        showDialog.value = false
                    }
                ) {
                    Text(
                        text = stringResource(id = R.string.search_dialog_select),
                        style = ShackleHotelBuddyTheme.typography.buttonNormal,
                    )
                }
            },
            dismissButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = ShackleHotelBuddyTheme.colors.teal),
                    onClick = { showDialog.value = false }
                ) {
                    Text(
                        text = stringResource(id = R.string.search_dialog_cancel),
                        style = ShackleHotelBuddyTheme.typography.buttonNormal,
                    )
                }
            }
        ) {
            DatePicker(
                state = datePickerState
            )
        }
    }
    return showDialog
}