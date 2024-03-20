package com.example.shacklehotelbuddy.features.search.api.request

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
)