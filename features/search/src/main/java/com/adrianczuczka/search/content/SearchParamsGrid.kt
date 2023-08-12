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
import com.adrianczuczka.ui.theme.ShackleHotelBuddyTheme

@Composable
fun ColumnScope.SearchParamsGrid(
    adultCount: Int,
    onAdultCountChange: (count: Int) -> Unit,
    childrenCount: Int,
    onChildrenCountChange: (count: Int) -> Unit,
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
            CheckInDateRow()
        }
        item {
            Divider()
        }
        item {
            CheckOutDateRow()
        }
        item {
            Divider()
        }
        item {
            AdultsCountRow(adultCount = adultCount, onCountChange = onAdultCountChange)
        }
        item {
            Divider()
        }
        item {
            ChildrenCountRow(childrenCount = childrenCount, onCountChange = onChildrenCountChange)
        }
    }
}