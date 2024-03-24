package com.example.shacklehotelbuddy.features.search.db

import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters

/**
 * Search parameter generator.
 *
 * @constructor Create empty constructor for search parameter generator
 */
class SearchParameterGenerator {
    /**
     * Get mockk1.
     *
     * @return [SearchParameters]
     */
    fun getMockk1() = SearchParameters(
        checkInTimestamp = 1,
        checkOutTimestamp = 2,
        adultCount = 1,
        childrenCount = 0
    )
}