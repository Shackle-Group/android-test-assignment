package com.example.shacklehotelbuddy.data.mapper

import com.example.shacklehotelbuddy.data.remote.model.CheckInDate
import com.example.shacklehotelbuddy.domain.model.hotelsearch.SearchDate

fun SearchDate.parseToFormattedString(): String {
    return "$day/$month/$year"
}

fun SearchDate.mapCheckInDate(): CheckInDate {
    return try {
        CheckInDate(
            this.day.toInt(),
            this.month.toInt(),
            this.year.toInt()
        )
    } catch (e: Exception) {
        CheckInDate(1, 1, 2025)
    }
}

fun String.toSearchDate(): SearchDate {
    return try {
        val slices = this.split("/").take(3)
        SearchDate(slices[0], slices[1], slices[2])
    } catch (e: Exception) {
        SearchDate("", "", "")
    }
}

fun parseSearchDate(day: Int, month: Int, year: Int): SearchDate {
    return SearchDate(day.toString(), month.toString(), year.toString())
}