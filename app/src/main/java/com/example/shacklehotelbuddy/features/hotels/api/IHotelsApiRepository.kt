package com.example.shacklehotelbuddy.features.hotels.api

import com.example.shacklehotelbuddy.base.api.models.RequestResult
import com.example.shacklehotelbuddy.features.hotels.api.responses.HotelSearchResponse
import com.example.shacklehotelbuddy.features.hotels.models.Hotel
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters
import java.util.Calendar

/**
 * Promises to provide hotels.
 */
interface IHotelsApiRepository {
    /**
     * Get hotels.
     *
     * @param searchParameters Search parameters
     * @return [RequestResult] with list of [Hotel]
     */
    suspend fun getHotels(searchParameters: SearchParameters): RequestResult<List<Hotel>>
}