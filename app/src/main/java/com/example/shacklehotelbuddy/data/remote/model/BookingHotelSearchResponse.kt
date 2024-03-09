package com.example.shacklehotelbuddy.data.remote.model

import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
data class BookingHotelSearchResponse(
    val result: List<BookingHotel?>
)

data class BookingHotel(
    @SerializedName("max_photo_url")
    val maxPhotoUrl: String?,
    @SerializedName("hotel_name")
    val hotelName: String?,
    val id: String?,
    val city: String?,
    @SerializedName("review_score")
    val reviewScore: String?,
    @SerializedName("composite_price_breakdown")
    val composite_price_breakdown: BookingPrice?
)

data class BookingPrice(
    @SerializedName("all_inclusive_amount")
    val all_inclusive_amount: AllInclusiveAmount?
)

data class AllInclusiveAmount(
    @SerializedName("amount_rounded")
    val amount_rounded: String?
)
