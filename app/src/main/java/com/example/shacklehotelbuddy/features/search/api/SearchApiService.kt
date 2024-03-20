package com.example.shacklehotelbuddy.features.search.api

import com.example.shacklehotelbuddy.base.api.BASE_API
import com.example.shacklehotelbuddy.base.api.IApiService
import com.example.shacklehotelbuddy.features.search.api.request.HotelSearchRequest
import com.example.shacklehotelbuddy.features.search.api.responses.HotelSearchResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

private const val LIST_API = "$BASE_API/properties/v2/list"

interface SearchApiService : IApiService {
    @POST(LIST_API)
    @Headers(
        "X-RapidAPI-Key: 4a45efc174mshea1e1cc5f6dd9b9p1bea7ajsn277943a06ca8",
        "X-RapidAPI-Host: hotels4.p.rapidapi.com"
    )
    suspend fun getHotels(@Body request: HotelSearchRequest): Response<HotelSearchResponse?>
}