package com.example.shacklehotelbuddy.features.hotels.api

import com.example.shacklehotelbuddy.base.api.BaseApiRepository
import com.example.shacklehotelbuddy.base.api.models.RequestResult
import com.example.shacklehotelbuddy.features.hotels.api.request.HotelSearchRequest
import com.example.shacklehotelbuddy.features.hotels.api.responses.HotelSearchResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchApiRepository @Inject constructor(
    private val searchApiService: SearchApiService
) : BaseApiRepository() {
    suspend fun getHotels(hotelSearchRequest: HotelSearchRequest): RequestResult<HotelSearchResponse> = safeApiCall {
        searchApiService.getHotels(hotelSearchRequest)
    }
}