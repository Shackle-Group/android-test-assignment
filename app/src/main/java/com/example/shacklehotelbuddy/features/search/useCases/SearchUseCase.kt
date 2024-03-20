package com.example.shacklehotelbuddy.features.search.useCases

import com.example.shacklehotelbuddy.features.search.db.SearchDbRepository
import com.example.shacklehotelbuddy.features.search.db.SearchEntity
import java.util.Calendar
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val searchRepository: SearchDbRepository
) {
    suspend fun getSearches() = searchRepository.getSearches()

    suspend fun saveSearchParameters(
        checkInDate: Calendar,
        checkOutDate: Calendar,
        adultCount: Int,
        childrenCount: Int,
    ) = searchRepository.insert(
        searchEntity = SearchEntity(
            checkInDate = checkInDate.timeInMillis,
            checkOutDate = checkOutDate.timeInMillis,
            adultCount = adultCount,
            childrenCount = childrenCount
        )
    )
}