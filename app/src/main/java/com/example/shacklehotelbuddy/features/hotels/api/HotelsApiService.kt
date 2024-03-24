package com.example.shacklehotelbuddy.features.hotels.api

import com.example.shacklehotelbuddy.base.api.IApiService
import com.example.shacklehotelbuddy.features.hotels.api.request.HotelSearchRequest
import com.example.shacklehotelbuddy.features.hotels.api.responses.HotelSearchResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private const val LIST_API = "properties/v2/list"

/**
 * Hotels API service.
 */
interface HotelsApiService : IApiService {
    /**
     * Get hotels.
     *
     * @param request [HotelSearchRequest]
     * @return [Response]
     */
    @POST(LIST_API)
    @Headers(
        "X-RapidAPI-Key: 4a45efc174mshea1e1cc5f6dd9b9p1bea7ajsn277943a06ca8", // Will cancel subscription at the 1 April.
        "X-RapidAPI-Host: hotels4.p.rapidapi.com"
    )
    suspend fun getHotels(@Body request: HotelSearchRequest): Response<HotelSearchResponse>
}