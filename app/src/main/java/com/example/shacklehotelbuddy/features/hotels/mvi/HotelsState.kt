package com.example.shacklehotelbuddy.features.hotels.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviState
import com.example.shacklehotelbuddy.features.hotels.models.Hotel

/**
 * Hotels state.
 *
 * @property isLoading Is loading
 * @property hotels List of hotels
 * @constructor Create [HotelsState]
 */
data class HotelsState(
    val isLoading: Boolean,
    val hotels: List<Hotel>
) : IMviState {
    companion object {
        /**
         * Default state.
         */
        val default = HotelsState(
            isLoading = false,
            hotels = emptyList()
        )
    }
}