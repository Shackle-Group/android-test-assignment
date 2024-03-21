package com.example.shacklehotelbuddy.features.search.ui

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

@Composable
fun BookingSearchItem(
    @DrawableRes iconRes: Int,
    @StringRes titleRes: Int,
    value: String,
    isLast: Boolean = false,
    actionByClick: () -> Unit
) {
    Column {
        Row(
            modifier = Modifier
                .height(52.dp)
                .fillMaxWidth()
                .clickable { actionByClick() }
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Icon(
                    // Assuming you have an icon for the calendar or similar
                    painter = painterResource(id = iconRes),
                    contentDescription = stringResource(id = titleRes),
                    modifier = Modifier.size(24.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = stringResource(id = titleRes),
                    style = ShackleHotelBuddyTheme.typography.bodyMedium,
                    color = ShackleHotelBuddyTheme.colors.grayText,
                )
            }
            VerticalDivider()
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(16.dp)
            ) {
                Spacer(modifier = Modifier.width(16.dp))
                Text(
                    text = value,
                    style = ShackleHotelBuddyTheme.typography.bodyMedium,
                    color = ShackleHotelBuddyTheme.colors.grayText,
                )
            }
        }
        if (!isLast) {
            HorizontalDivider()
        }
    }
}

@Preview
@Composable
fun CheckDatePreview() {
    ShackleHotelBuddyTheme {
        BookingSearchItem(
            iconRes = R.drawable.event_upcoming,
            titleRes = R.string.search_check_in,
            value = "DD / MM / YYYY",
            isLast = false
        ) {}
    }
}