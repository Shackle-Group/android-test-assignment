package com.adrianczuczka.features.properties.content

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.adrianczuczka.common.ui.theme.ShackleHotelBuddyTheme
import com.adrianczuczka.features.properties.R
import com.adrianczuczka.features.properties.model.PropertyListItem
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun PropertyRow(
    propertyListItem: PropertyListItem,
) {
    Column(
        modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)
    ) {
        GlideImage(
            imageModel = { propertyListItem.imageUrl },
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(16f / 9f)
                .clip(RoundedCornerShape(8.dp, 8.dp, 8.dp, 8.dp)),
            loading = {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
        ) {
            Text(
                text = propertyListItem.title,
                modifier = Modifier
                    .padding(end = 8.dp)
                    .weight(1f),
                style = ShackleHotelBuddyTheme
                    .typography
                    .bodyMedium
                    .copy(
                        fontWeight = FontWeight.Bold
                    )
            )
            Row {
                Icon(painter = painterResource(id = R.drawable.star), contentDescription = null)
                Text(text = propertyListItem.rating.toString())
            }
        }
        Text(
            text = propertyListItem.subtitle,
            modifier = Modifier.padding(top = 4.dp),
            style = ShackleHotelBuddyTheme.typography.bodyMedium,
            color = ShackleHotelBuddyTheme.colors.grayText
        )
        Text(
            text = stringResource(
                id = R.string.properties_row_nightly_rate_label,
                propertyListItem.dailyRate
            ), modifier = Modifier.padding(top = 4.dp)
        )
    }
}