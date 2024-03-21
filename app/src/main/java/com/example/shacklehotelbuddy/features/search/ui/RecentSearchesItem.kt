package com.example.shacklehotelbuddy.features.search.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

@Composable
fun ResentSearchesItem(
    timeRange: String,
    isLast: Boolean = false,
    actionByIcon: () -> Unit,
    actionByDate: () -> Unit
) {
    Column {
        Row(
            horizontalArrangement = Arrangement.Start,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(48.dp)
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clickable { actionByIcon() }
            ) {
                Box(
                    modifier = Modifier.align(Alignment.Center)
                ) {
                    Icon(
                        // Assuming you have an icon for the calendar or similar
                        painter = painterResource(id = R.drawable.manage_history),
                        tint = ShackleHotelBuddyTheme.colors.teal,
                        contentDescription = stringResource(id = R.string.search_recent_searches),
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            VerticalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .height(48.dp)
                    .clickable { actionByDate() }) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .padding(8.dp)
                        .fillMaxWidth()
                ) {
                    Text(
                        text = timeRange,
                        style = ShackleHotelBuddyTheme.typography.bodyMedium,
                        color = ShackleHotelBuddyTheme.colors.grayText,
                    )
                    Text(
                        text = stringResource(id = R.string.search_recent_item_content, 1, 0),
                        style = ShackleHotelBuddyTheme.typography.bodyMedium,
                        color = ShackleHotelBuddyTheme.colors.grayText,
                        modifier = Modifier.padding(end = 16.dp)
                    )
                }
            }
        }
        if (!isLast) {
            HorizontalDivider()
        }
    }
}

@Composable
fun NumberPicker(
    range: IntRange = 1..60,
    onValueChange: (Int) -> Unit
) {
    // Mutable state to keep track of the current value
    var sliderPosition by remember { mutableFloatStateOf(range.first.toFloat()) }

    Column(
        modifier = Modifier.padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Integer value of the slider's position
        val intValue = sliderPosition.toInt()

        // Text display of the current number
        Text("Selected number: $intValue")

        // Slider composable
        Slider(
            value = sliderPosition,
            onValueChange = { newValue ->
                sliderPosition = newValue
                onValueChange(newValue.toInt())
            },
            valueRange = range.first.toFloat()..range.last.toFloat(),
            steps = range.last - range.first - 1
        )
    }
}

@Preview
@Composable
fun ResentSearchesItemPreview() {
    ShackleHotelBuddyTheme {
        ResentSearchesItem(
            timeRange = "03 / 07 / 2024 - 15 / 07 / 2024",
            isLast = false,
            actionByIcon = {},
            actionByDate = {},
        )
    }
}