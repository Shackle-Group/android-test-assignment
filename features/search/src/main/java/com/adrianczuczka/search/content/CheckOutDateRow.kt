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
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adrianczuczka.search.R
import com.adrianczuczka.ui.theme.ShackleHotelBuddyTheme

@Composable
fun CheckOutDateRow() {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .background(Color.White),
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.event_available),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.search_screen_check_out_date_text),
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
                    // TODO: Open date picker
                }
                .padding(16.dp)
                .weight(1f)
        ) {
            Text(
                text = stringResource(id = R.string.search_screen_date_label),
                style = ShackleHotelBuddyTheme
                    .typography
                    .bodyMedium
                    .copy(
                        color = ShackleHotelBuddyTheme.colors.grayText
                    )
            )
        }
    }
}