package com.adrianczuczka.search.state

data class SearchState(
    val datePickerState: DatePickerState? = null,
    val adultAmount: Int = 0,
    val childrenAmount: Int = 0,
) {
    enum class DatePickerState {
        CHECK_IN,
        CHECK_OUT
    }
}