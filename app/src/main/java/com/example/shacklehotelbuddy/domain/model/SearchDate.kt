package com.example.shacklehotelbuddy.domain.model

data class SearchDate(
    val day: String,
    val month: String,
    val year: String
) {
    override fun toString(): String = "${day.ifEmpty { "DD" }}/${month.ifEmpty { "MM" }}/${year.ifEmpty { "YY" }}"
    
    fun toBookingFormat(): String = "${year.ifEmpty { "YY" }}-${month.ifEmpty { "MM" }}-${day.ifEmpty { "DD" }}"
}