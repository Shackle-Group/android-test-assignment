package com.example.shacklehotelbuddy.features.search.mvi

import com.example.shacklehotelbuddy.base.mvi.IMviIntent
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters

/**
 * Search intent.
 *
 * @constructor Create empty constructor for search intent
 */
sealed class SearchIntent : IMviIntent {
    /**
     * Load last search parameters.
     */
    data object LoadDefaultContent : SearchIntent()

    /**
     * Update check in date.
     *
     * @property timestamp Timestamp
     * @constructor Create [UpdateCheckInDate]
     */
    data class UpdateCheckInDate(val timestamp: Long) : SearchIntent()

    /**
     * Update check out date.
     *
     * @property timestamp Timestamp
     * @constructor Create [UpdateCheckOutDate]
     */
    data class UpdateCheckOutDate(val timestamp: Long) : SearchIntent()

    /**
     * Update adults.
     *
     * @property count Count of adults
     * @constructor Create [UpdateAdults]
     */
    data class UpdateAdults(val count: Int) : SearchIntent()

    /**
     * Update children.
     *
     * @property count Count of children
     * @constructor Create [UpdateChildren]
     */
    data class UpdateChildren(val count: Int) : SearchIntent()

    /**
     * Remain search parameters.
     *
     * @property searchParameters Search parameters
     * @constructor Create [RemainSearchParameters]
     */
    data class RemainSearchParameters(val searchParameters: SearchParameters) : SearchIntent()

    /**
     * Repeat search.
     *
     * @property searchParameters Search parameters
     * @constructor Create [RepeatSearch]
     */
    data class RepeatSearch(val searchParameters: SearchParameters) : SearchIntent()

    /**
     * Update location.
     */
    data object MakeSearch : SearchIntent()
}