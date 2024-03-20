package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

data class HotelSearchRequest(
    @SerializedName("currency")                 val currency: String,
    @SerializedName("eapid")                    val eapid: Long,
    @SerializedName("locale")                   val locale: String,
    @SerializedName("siteId")                   val siteID: Long,
    @SerializedName("destination")              val destination: DestinationRequest,
    @SerializedName("checkInDate")              val checkInDate: CheckDateRequest,
    @SerializedName("checkOutDate")             val checkOutDate: CheckDateRequest,
    @SerializedName("rooms")                    val rooms: List<RoomRequest>,
    @SerializedName("resultsStartingIndex")     val resultsStartingIndex: Long,
    @SerializedName("resultsSize")              val resultsSize: Long,
    @SerializedName("sort")                     val sort: String,
    @SerializedName("filters")                  val filters: FiltersRequest
) {
    companion object {
        fun getInstance(
            checkInDate: CheckDateRequest,
            checkOutDate: CheckDateRequest,
            rooms: List<RoomRequest>,
        ) = HotelSearchRequest(
            currency = "USD",
            eapid = 1,
            locale = "en_US",
            siteID = 300000001,
            destination = DestinationRequest(
                regionId = "6054439"
            ),
            checkInDate = checkInDate,
            checkOutDate = checkOutDate,
            rooms = rooms,
            resultsStartingIndex = 0,
            resultsSize = 1,
            sort = "PRICE_LOW_TO_HIGH",
            filters = FiltersRequest(
                price = PriceRequest(
                    max = 150,
                    min = 100
                )
            )
        )
    }
}