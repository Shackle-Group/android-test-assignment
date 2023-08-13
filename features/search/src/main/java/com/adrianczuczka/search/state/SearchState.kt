package com.adrianczuczka.search.state

import java.util.Date

data class SearchState(
    val datePickerState: DatePickerState? = null,
    val checkInDate: Date? = null,
    val checkOutDate: Date? = null,
    val adultCount: Int = 0,
    val childrenCount: Int = 0,
) {
    enum class DatePickerState {
        CHECK_IN,
        CHECK_OUT
    }
}