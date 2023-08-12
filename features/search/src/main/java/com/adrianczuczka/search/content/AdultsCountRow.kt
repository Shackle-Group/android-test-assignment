package com.adrianczuczka.search.content

import androidx.compose.foundation.background
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
fun AdultsCountRow(
    adultCount: Int,
    onCountChange: (count: Int) -> Unit,
) {
    Row(
        modifier = Modifier
            .height(IntrinsicSize.Max)
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .weight(1f)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.person),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.search_screen_adults_text),
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
        AmountTextField(
            amount = adultCount,
            onAmountChange = { amount -> onCountChange(amount) },
            modifier = Modifier
                .fillMaxSize()
                .weight(1f)
        )
    }
}