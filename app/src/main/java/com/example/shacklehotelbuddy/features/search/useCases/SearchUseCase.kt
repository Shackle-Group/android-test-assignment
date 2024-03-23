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
    suspend fun getLastActualSearches(count: Int) = searchRepository.getLastSearchParameters(count)

    /**
     * Save search parameters.
     *
     * @param searchParameters Search parameters
     */
    suspend fun saveSearchParameters(searchParameters: SearchParameters) =
        searchRepository.insertOrUpdate(searchParameters)
}