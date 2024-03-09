package com.example.shacklehotelbuddy.presentation.ui.views

import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.mockHotelList
import com.example.shacklehotelbuddy.presentation.theme.ShackleHotelBuddyTheme
import com.example.shacklehotelbuddy.presentation.ui.main.HotelSearchUiState
import com.example.shacklehotelbuddy.presentation.ui.main.MainViewModel


@ExperimentalMaterial3Api
@Composable
fun HotelListScreen(viewModel: MainViewModel, navController: NavHostController) {

    val hotelList by viewModel.hotelList.collectAsState()
    val uiState by viewModel.uiState.collectAsState()

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Column {
            Row(modifier = Modifier.padding(top = 16.dp, bottom = 8.dp)) {
                Icon(
                    painter = painterResource(id = R.drawable.arrow_back),
                    contentDescription = stringResource(id = R.string.icon_back),
                    Modifier
                        .size(20.dp)
                        .clickable { navController.popBackStack() }
                )
                Text(
                    text = stringResource(id = R.string.search_results),
                    style = ShackleHotelBuddyTheme.typography.buttonMedium,
                    modifier = Modifier
                        .height(32.dp)
                        .fillMaxWidth(),
                    textAlign = TextAlign.Center
                )
            }

            when(uiState) {
                HotelSearchUiState.Done -> HotelList(hotelList)
                HotelSearchUiState.InProgress -> ProgressView()
                HotelSearchUiState.Error -> ErrorView()
                else -> {}
            }
        }
    }
}

@Composable
fun ProgressView() {
    Box(modifier = Modifier.fillMaxSize()) {
        CircularProgressIndicator(
            color = ShackleHotelBuddyTheme.colors.black,
            modifier = Modifier
                .padding(8.dp)
                .size(60.dp)
                .align(Alignment.Center)
        )
    }
}
@Composable
fun ErrorView() {
    CentralText(stringResource(id = R.string.error_endpoint))
    Toast.makeText(
        LocalContext.current,
        stringResource(R.string.network_error),
        Toast.LENGTH_SHORT
    ).show()
}

@Composable
fun HotelList(hotelList: List<Hotel>) {
    if (hotelList.isEmpty()) {
        CentralText(stringResource(id = R.string.no_hotel_found))
        // ADD-ON: nice finished icon
    } else {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(hotelList) {
                HotelItem(it)
            }
        }
    }
}

@Composable
fun HotelItem(hotel: Hotel) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        AsyncImage(
            model = hotel.imageUrl,
            contentDescription = stringResource(id = R.string.icon_image),
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
                    style = ShackleHotelBuddyTheme.typography.bodyMediumBold,
                    color = ShackleHotelBuddyTheme.colors.black
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = hotel.location,
                    style = ShackleHotelBuddyTheme.typography.bodyMedium,
                    color = ShackleHotelBuddyTheme.colors.grayText
                )
                Spacer(modifier = Modifier.height(3.dp))
                if (hotel.price.isEmpty()) {
                    Text(
                        text = stringResource(id = R.string.not_available),
                        style = ShackleHotelBuddyTheme.typography.bodyMedium,
                        color = ShackleHotelBuddyTheme.colors.black
                    )
                } else {
                    Text(
                        text = "${hotel.price} per night",
                        style = ShackleHotelBuddyTheme.typography.bodyMediumBold,
                        color = ShackleHotelBuddyTheme.colors.black
                    )
                }
            }
            Row {
                Icon(
                    painter = painterResource(id = R.drawable.star),
                    contentDescription = stringResource(id = R.string.icon_rating)
                )
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = hotel.star,
                    style = ShackleHotelBuddyTheme.typography.bodyMediumBold,
                    color = ShackleHotelBuddyTheme.colors.black
                )
            }
        }

    }
}

@Composable
fun CentralText(text: String) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = text,
            style = ShackleHotelBuddyTheme.typography.bodyMedium,
            modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center
        )
    }
}

@Preview(showBackground = true)
@Composable
fun HotelListPreview() {
    ShackleHotelBuddyTheme {
        HotelList(mockHotelList)
    }
}

//@Preview(showBackground = true)
//@Composable
//fun HotelListPreview(
//    @PreviewParameter(MyPreviewParameterProvider::class) viewModel: MainViewModel
//) {
//    ShackleHotelBuddyTheme {
//        HotelListScreen(viewModel, rememberNavController())
//    }
//}
