package com.example.shacklehotelbuddy.features.search.useCases

import java.util.Calendar
import javax.inject.Inject

/**
 * Factory method to work with [Calendar].
 *
 * @constructor Create empty constructor for time use case
 */
class CheckDateUseCase @Inject constructor() {
    /**
     * Get default check in date.
     *
     * @return The next day after current
     */
    fun getDefaultCheckInDate() = Calendar.getInstance().apply {
        add(Calendar.DAY_OF_YEAR, 1)
    }.timeInMillis

    /**
     * Get default check out date.
     *
     * @return The 8th day after current - a whole week
     */
    fun getDefaultCheckOutDate() = Calendar.getInstance().apply {
        add(Calendar.DAY_OF_YEAR, 8)
    }.timeInMillis

    /**
     * Get new check out date.
     *
     * @param checkInDate Check in date
     * @param currentCheckOutDate Current check out date
     * @return A new check out date
     */
    fun getNewCheckOutDate(checkInDate: Long, currentCheckOutDate: Long?): Long? =
        if (currentCheckOutDate == null || checkInDate > currentCheckOutDate) {
            null
        } else {
            currentCheckOutDate
        }
}