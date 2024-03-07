package com.example.shacklehotelbuddy.data.api

import com.example.shacklehotelbuddy.data.model.HotelData
import com.example.shacklehotelbuddy.data.model.HotelRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    @POST("properties/v2/list")
    suspend fun getHotelList(@Body hotelRequest: HotelRequest): HotelData
}