package com.example.shacklehotelbuddy.features.search.ui.dialogs

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

/**
 * Input number dialog for adult and children counters.
 *
 * @param initValue Init value
 * @param minLimit Minimal value
 * @param onConfirmation On confirmation
 * @return Flow to control dialog visibility
 */
@Composable
fun inputNumberDialog(
    initValue: Int = 0,
    minLimit: Int = 0,
    onConfirmation: (Int) -> Unit,
): MutableState<Boolean> {
    var number by remember(initValue) { mutableIntStateOf(initValue) }
    val showDialog = remember { mutableStateOf(false) }
    if (showDialog.value) {
        LaunchedEffect(number) {
            onConfirmation(number)
        }

        Dialog(onDismissRequest = { showDialog.value = false }) {
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
                    .clip(shape = RoundedCornerShape(16.dp))
                    .background(CardDefaults.cardColors(containerColor = ShackleHotelBuddyTheme.colors.white).containerColor)
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(16.dp),
            ) {
                Text(
                    text = stringResource(id = R.string.search_dialog_title),
                    style = ShackleHotelBuddyTheme.typography.subTitle,
                    color = ShackleHotelBuddyTheme.colors.grayText,
                )
                Spacer(modifier = Modifier.height(16.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = ShackleHotelBuddyTheme.colors.teal),
                        enabled = number > minLimit,
                        onClick = { if (number > minLimit) number-- }
                    ) {
                        Text("-")
                    }
                    Spacer(modifier = Modifier.width(16.dp))
                    Text(
                        text = "$number",
                        modifier = Modifier.align(alignment = Alignment.CenterVertically),
                        style = ShackleHotelBuddyTheme.typography.subTitle,
                        color = ShackleHotelBuddyTheme.colors.grayText,
                    )
                    Spacer(modifier = Modifier.width(16.dp))
                    Button(
                        colors = ButtonDefaults.buttonColors(containerColor = ShackleHotelBuddyTheme.colors.teal),
                        onClick = { number++ }
                    ) {
                        Text("+")
                    }
                }
            }
        }
    }
    return showDialog
}