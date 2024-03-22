package com.example.shacklehotelbuddy.features.search.useCases

import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters
import com.example.shacklehotelbuddy.features.search.db.ISearchParametersDbRepository
import com.example.shacklehotelbuddy.features.search.db.SearchParametersDbRepository
import javax.inject.Inject

/**
 * Search use case.
 *
 * @property searchRepository [SearchParametersDbRepository]
 * @constructor Create [SearchUseCase]
 */
class SearchUseCase @Inject constructor(private val searchRepository: ISearchParametersDbRepository) {
    /**
     * Get last actual searches requests.
     *
     * @param count Count
     * @return list of search parameters.
     */
    suspend fun getLastActualSearches(count: Int) = searchRepository.getLastActualSearches(count)

    /**
     * Save search parameters.
     *
     * @param checkInTimestamp Check in timestamp
     * @param checkOutTimestamp Check out timestamp
     * @param adultCount Adult count
     * @param childrenCount Children count
     */
    suspend fun saveSearchParameters(
        checkInTimestamp: Long,
        checkOutTimestamp: Long,
        adultCount: Int,
        childrenCount: Int,
    ) = searchRepository.insert(
        searchParameters = SearchParameters(
            checkInTimestamp = checkInTimestamp,
            checkOutTimestamp = checkOutTimestamp,
            adultCount = adultCount,
            childrenCount = childrenCount
        )
    )
}