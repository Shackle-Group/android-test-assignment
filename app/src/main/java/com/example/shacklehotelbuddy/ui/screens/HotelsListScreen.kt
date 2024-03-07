package com.example.shacklehotelbuddy.ui.screens

import ShackleHotelBuddy.R
import android.app.Activity
import android.location.Address
import android.location.Geocoder
import android.util.Log
import androidx.compose.Composable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.shacklehotelbuddy.data.model.Property
import com.example.shacklehotelbuddy.ui.components.CustomText
import com.example.shacklehotelbuddy.ui.event.HotelEvent
import com.example.shacklehotelbuddy.ui.view_model.HotelViewModel
import java.util.Locale

@androidx.compose.runtime.Composable
@Composable
fun HotelsListScreen(navController: NavController, viewModel: HotelViewModel) {

    val state by viewModel.hotelEvent.collectAsState(HotelEvent.Loading)

    LaunchedEffect( true){
        viewModel.getHotelList()
    }

    when(state){
        is HotelEvent.Error -> {
            println("ERROR")
        }
        HotelEvent.Loading -> {
            println("LOADING")
        }
        is HotelEvent.Success -> {
            val hotels = (state as HotelEvent.Success).data
            Box(
                modifier = Modifier.fillMaxSize().fillMaxWidth().background(Color.White)
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(modifier = Modifier.fillMaxWidth().padding(top = 16.dp, end = 18.dp, start = 2.dp)
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.arrow_back),
                            contentDescription = "back button",
                            modifier = Modifier.weight(0.1f).clickable {
                                viewModel.resetFormData()
                                navController.popBackStack()
                            }
                        )
                        CustomText(
                            text = stringResource(R.string.search_results),
                            fontSize = 20,
                            fontWeight = FontWeight.Normal,
                            color = Color.Black,
                            modifier = Modifier.weight(0.9f),
                            textAlign = TextAlign.Center)
                    }
                    LazyColumn(
                        contentPadding = PaddingValues(horizontal = 16.dp, vertical = 16.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp),
                    ) {
                        items(hotels.data.propertySearch.properties) {
                            HotelsCard(hotel = it)
                        }
                    }
                }
            }
        }
    }
}

@androidx.compose.runtime.Composable
@Composable
fun HotelsCard(
    hotel: Property
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(corner = CornerSize(16.dp))
    ) {
        Column(
            modifier = Modifier.background(Color.White).fillMaxWidth(),
        ) {
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(corner = CornerSize(16.dp))
            ) {
                val painter = rememberImagePainter(data = hotel.propertyImage.image.url)
                Image(
                    modifier = Modifier.aspectRatio(1.5F),
                    painter = painter,
                    contentDescription = "Hotel Image", contentScale = ContentScale.FillBounds
                )

            }
            Column(
                modifier = Modifier.background(Color.White).padding(horizontal = 10.dp, vertical = 10.dp).fillMaxWidth(),
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        modifier = Modifier.weight(0.85f),
                        fontWeight = FontWeight.Bold,
                        fontSize = 14.sp,
                        maxLines = 1,
                        textAlign = TextAlign.Start,
                        overflow = TextOverflow.Ellipsis,
                        text = hotel.name
                    )

                    val annotatedString = buildAnnotatedString {
                        appendInlineContent(id = "imageId")
                        append(hotel.reviews.score.toString())
                    }
                    val inlineContentMap = mapOf(
                        "imageId" to InlineTextContent(
                            Placeholder(20.sp, 20.sp, PlaceholderVerticalAlign.TextCenter)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.star),
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(bottom = 2.dp),
                                contentDescription = "star"
                            )
                        }
                    )
                    Text(
                        annotatedString,
                        inlineContent = inlineContentMap,
                        modifier = Modifier.weight(0.15f),
                        textAlign = TextAlign.End,
                        fontSize = 16.sp
                    )

                }
                val address = getAddressString(
                    LATITUDE = hotel.mapMarker.latLong.latitude,
                    LONGITUDE = hotel.mapMarker.latLong.longitude)

                CustomText(
                    text = address.toString(),
                    fontSize = 12,
                    fontWeight = FontWeight.Normal,
                    color = Color.Black,
                    modifier = Modifier,
                    textAlign = TextAlign.Start)
                CustomText(
                    text = hotel.price.lead.formatted + " night",
                    fontSize = 12,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier,
                    textAlign = TextAlign.Start)
            }
        }
    }
}

@androidx.compose.runtime.Composable
private fun getAddressString(LATITUDE: Double, LONGITUDE: Double): String? {
    var cityCountry = ""
    val geocoder = Geocoder(LocalContext.current as Activity, Locale.getDefault())
    try {
        val addresses: List<Address>? = geocoder.getFromLocation(LATITUDE, LONGITUDE, 1)
        if (addresses != null) {
            val returnedAddress: Address = addresses[0]
            val address = returnedAddress.getAddressLine(0)
            val city = returnedAddress.locality
            val state = returnedAddress.adminArea
            val zip = returnedAddress.postalCode
            val country = returnedAddress.countryName
            if(city != null) {
                cityCountry = city + ", " + country
            } else {
                cityCountry = country
            }
        } else {
            Log.w("Location: ", "No Address returned!")
        }
    } catch (e: Exception) {
        e.printStackTrace()
        Log.w("Location: ", "Can't get Address!")
    }
    return cityCountry
}
