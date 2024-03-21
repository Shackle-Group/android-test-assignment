package com.example.shacklehotelbuddy.features.hotels.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviState
import com.example.shacklehotelbuddy.features.hotels.models.Hotel

data class HotelsState(
    val id: Int,
    val hotels: List<Hotel>
) : IMviState {
    companion object {
        val default = HotelsState(id = 0, hotels = emptyList())
    }
}