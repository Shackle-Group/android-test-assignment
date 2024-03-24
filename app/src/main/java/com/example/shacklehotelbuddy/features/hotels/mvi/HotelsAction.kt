package com.example.shacklehotelbuddy.features.hotels.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviAction

/**
 * Hotels action.
 */
sealed class HotelsAction : IMviAction {
    /**
     * Open hotel details.
     *
     * @property hotelId Hotel ID
     * @constructor Create [OpenHotelDetails]
     */
    data class OpenHotelDetails(val hotelId: String) : HotelsAction()

    /**
     * Show error.
     *
     * @property code Code
     * @property message Message
     * @constructor Create [ShowError]
     */
    data class ShowError(val code: Int, val message: String) : HotelsAction()
}