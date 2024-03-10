package com.example.shacklehotelbuddy.presentation.utils

import com.example.shacklehotelbuddy.R
import com.example.shacklehotelbuddy.domain.model.ui.SearchUiError
import kotlin.math.min
import kotlin.math.max

fun Int.updateCounter(increment: Boolean, minValue: Int = 0, maxValue: Int = 100): Int {
    return if (increment) {
        min(this + 1, maxValue)
    } else {
        max(this - 1, minValue)
    }
}

fun SearchUiError.parseSearchUiError(): Int {
    return when (this) {
        SearchUiError.CheckInError -> R.string.error_check_in
        SearchUiError.CheckOutError -> R.string.error_check_out
        SearchUiError.AdultsError -> R.string.error_adults
        SearchUiError.ChildrenError -> R.string.error_children
    }
}