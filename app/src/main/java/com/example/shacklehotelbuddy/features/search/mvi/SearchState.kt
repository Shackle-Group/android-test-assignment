package com.example.shacklehotelbuddy.features.search.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviState
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters

/**
 * Search state.
 *
 * @property checkInTimestamp Check-in timestamp
 * @property checkOutTimestamp Check-out timestamp
 * @property adultCount Number of adults
 * @property childrenCount Number of children
 * @property lastActualSearches Last actual searches
 * @property isBtnActive Is search btn active
 * @constructor Create [SearchState]
 */
data class SearchState(
    val checkInTimestamp: Long,
    val checkOutTimestamp: Long?,
    val adultCount: Int,
    val childrenCount: Int,
    val lastActualSearches: List<SearchParameters> = emptyList(),
    val isBtnActive: Boolean
) : IMviState {
    companion object {
        val default = SearchState(
            checkInTimestamp = 0,
            checkOutTimestamp = 0,
            adultCount = 0,
            childrenCount = 0,
            lastActualSearches = emptyList(),
            isBtnActive = false
        )
    }
}