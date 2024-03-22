package com.example.shacklehotelbuddy.features.hotels.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviAction

/**
 * Hotels action.
 */
sealed class HotelsAction : IMviAction {
    /**
     * Show error.
     *
     * @property code Code
     * @property message Message
     * @constructor Create [ShowError]
     */
    data class ShowError(val code: Int, val message: String) : HotelsAction()
}