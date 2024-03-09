package com.example.shacklehotelbuddy.data.remote.service

import com.example.shacklehotelbuddy.data.remote.model.HotelSearchRequest
import com.example.shacklehotelbuddy.data.remote.model.HotelSearchResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

const val API_PROPERTIES_LIST = "properties/v2/list"

interface HotelSearchService {

    @POST(API_PROPERTIES_LIST)
    suspend fun searchHotels(@Body request: HotelSearchRequest): Response<HotelSearchResponse>
}