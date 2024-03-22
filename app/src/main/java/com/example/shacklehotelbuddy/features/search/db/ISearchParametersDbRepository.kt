package com.example.shacklehotelbuddy.features.search.db

import com.example.shacklehotelbuddy.base.db.IDbRepository
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters

/**
 * Search db repository.
 */
interface ISearchParametersDbRepository : IDbRepository {
    /**
     * Get last actual variants of search.
     *
     * @param count Count
     * @return list of search parameters.
     */
    suspend fun getLastActualSearches(count: Int): List<SearchParameters>

    /**
     * Insert search parameters.
     *
     * @param searchParameters [SearchParameters]
     */
    suspend fun insert(searchParameters: SearchParameters)
}