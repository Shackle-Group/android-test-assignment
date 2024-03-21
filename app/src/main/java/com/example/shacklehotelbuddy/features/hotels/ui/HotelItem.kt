package com.example.shacklehotelbuddy.features.hotels.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.features.hotels.models.Hotel
import com.example.shacklehotelbuddy.ui.theme.ShackleHotelBuddyTheme

@Composable
fun HotelItem(
    hotel: Hotel,
    onClick: (hotelId: String) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick(hotel.id) }
    ) {
        AsyncImage(
            model = rememberAsyncImagePainter(hotel.url),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .border(BorderStroke(1.dp, Color(0x268B8A8B)), RoundedCornerShape(16.dp))
                .clip(RoundedCornerShape(16.dp))
        )
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp, bottom = 0.dp, start = 3.dp, end = 3.dp)
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = hotel.name,
                    style = ShackleHotelBuddyTheme.typography.bodyMedium.copy(
                        fontWeight = FontWeight.W400
                    ),
                    color = ShackleHotelBuddyTheme.colors.black
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = hotel.location,
                    style = ShackleHotelBuddyTheme.typography.bodyMedium,
                    color = ShackleHotelBuddyTheme.colors.grayText
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = "${hotel.price} night",
                    style = ShackleHotelBuddyTheme.typography.bodyBold,
                    color = ShackleHotelBuddyTheme.colors.black
                )
            }
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = hotel.reviews,
                    style = ShackleHotelBuddyTheme.typography.bodyBold,
                    color = ShackleHotelBuddyTheme.colors.black
                )
            }
        }
    }
}