package com.example.shacklehotelbuddy.features.hotels.api.request

import com.google.gson.annotations.SerializedName

/**
 * Hotel search request.
 *
 * @property currency Currency
 * @property eapid Eapid
 * @property locale Locale
 * @property siteID Site ID
 * @property destination Destination
 * @property checkInDate Check in date
 * @property checkOutDate Check out date
 * @property rooms Rooms
 * @property resultsStartingIndex Results starting index
 * @property resultsSize Results size
 * @property sort Sort
 * @property filters Filters
 * @constructor Create [HotelSearchRequest]
 */
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
        /**
         * Get stub instance.
         *
         * @param checkInDate Check in date
         * @param checkOutDate Check out date
         * @param rooms Rooms
         * @return [HotelSearchRequest]
         */
        fun getStubInstance(
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

        /**
         * Get stub instance 2.
         *
         * @return [HotelSearchRequest]
         */
        fun getStubInstance2() = HotelSearchRequest(
            currency = "USD",
            eapid = 1,
            locale = "en_US",
            siteID = 300000001,
            destination = DestinationRequest(
                regionId = "6054439"
            ),
            checkInDate = CheckDateRequest(
                day = 10,
                month = 10,
                year = 2022
            ),
            checkOutDate = CheckDateRequest(
                day = 15,
                month = 10,
                year = 2022
            ),
            rooms = listOf(
                RoomRequest(
                    adults = 1,
                    children = listOf( )
                )
            ),
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