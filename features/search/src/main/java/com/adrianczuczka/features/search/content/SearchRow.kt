package com.adrianczuczka.features.search.content

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.adrianczuczka.common.ui.theme.ShackleHotelBuddyTheme
import com.adrianczuczka.data.properties.search.model.DbSearchInfo
import com.adrianczuczka.features.search.R

@Composable
fun SearchRow(
    searchInfo: DbSearchInfo,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .padding(top = 8.dp)
            .clip(RoundedCornerShape(16.dp, 16.dp, 16.dp, 16.dp))
            .background(Color.White)
            .clickable { onClick() }
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .height(IntrinsicSize.Max),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                painter = painterResource(id = R.drawable.manage_history),
                contentDescription = null,
                modifier = Modifier.padding(16.dp),
                tint = ShackleHotelBuddyTheme.colors.teal
            )
            Divider(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(1.dp)
                    .background(ShackleHotelBuddyTheme.colors.grayBorder)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(
                        id = R.string.search_screen_date_range_label,
                        searchInfo.checkInDate.day,
                        searchInfo.checkInDate.month,
                        searchInfo.checkInDate.year,
                        searchInfo.checkOutDate.day,
                        searchInfo.checkOutDate.month,
                        searchInfo.checkOutDate.year,
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                )
                Text(
                    text = stringResource(
                        id = R.string.search_screen_adult_and_children_label,
                        searchInfo.adultCount,
                        searchInfo.childrenCount
                    ),
                    modifier = Modifier.padding(end = 16.dp)
                )
            }
        }
    }
}