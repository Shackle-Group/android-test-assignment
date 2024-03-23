package com.example.shacklehotelbuddy.features.hotels.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviIntent

/**
 * Hotels intent.
 */
sealed class HotelsIntent : IMviIntent {
    /**
     * Load hotels.
     */
    data object LoadHotels : HotelsIntent()

    /**
     * Tap to hotel.
     *
     * @property hotelId Hotel ID
     * @constructor Create [TapToHotel]
     */
    data class TapToHotel(val hotelId: String) : HotelsIntent()
}