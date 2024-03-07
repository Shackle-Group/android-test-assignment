package com.example.shacklehotelbuddy.ui.event

import com.example.shacklehotelbuddy.data.model.HotelData

sealed class HotelEvent {
    object Loading : HotelEvent()
    data class Error(val error: String) : HotelEvent()
    data class Success(val data: HotelData) : HotelEvent()
}