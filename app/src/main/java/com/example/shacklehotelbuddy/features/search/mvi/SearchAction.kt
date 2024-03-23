package com.example.shacklehotelbuddy.features.search.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviAction

/**
 * Search action.
 *
 * @constructor Create empty constructor for search action
 */
sealed class SearchAction : IMviAction {
    /**
     * Show hotels.
     */
    data object ShowHotels : SearchAction()
}