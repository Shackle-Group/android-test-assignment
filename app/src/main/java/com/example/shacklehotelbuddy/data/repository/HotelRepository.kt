package com.example.shacklehotelbuddy.data.repository

import com.example.shacklehotelbuddy.data.api.ApiService
import com.example.shacklehotelbuddy.data.event.ServerResponse
import com.example.shacklehotelbuddy.data.model.HotelData
import com.example.shacklehotelbuddy.data.model.HotelRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface HotelRepository {
    fun getHotelList(request: HotelRequest): Flow<ServerResponse<HotelData>>
}

class HotelRepositoryImpl @Inject constructor(private val api: ApiService) : HotelRepository {

    override fun getHotelList(request: HotelRequest): Flow<ServerResponse<HotelData>> = flow {
        try {
            val result = api.getHotelList(request)
            emit(ServerResponse.Success(result))
        } catch (ex: Exception) {
            emit(ServerResponse.Error(ex.message.toString()))
        }
    }

}