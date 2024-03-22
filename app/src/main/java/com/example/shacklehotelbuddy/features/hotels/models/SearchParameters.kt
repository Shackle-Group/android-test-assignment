package com.example.shacklehotelbuddy.features.hotels.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Search parameters.
 *
 * @property checkInTimestamp Check-in timestamp
 * @property checkOutTimestamp Check-out timestamp
 * @property adultCount Adult count
 * @property childrenCount Children count
 * @constructor Create [SearchParameters]
 */
@Parcelize
data class SearchParameters(
    val checkInTimestamp: Long,
    val checkOutTimestamp: Long,
    val adultCount: Int,
    val childrenCount: Int
) : Parcelable