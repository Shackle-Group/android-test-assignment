package com.example.shacklehotelbuddy.features.hotels.useCases

import com.example.shacklehotelbuddy.base.api.models.RequestResult
import com.example.shacklehotelbuddy.base.api.useCases.ApiUseCase
import com.example.shacklehotelbuddy.features.hotels.api.IHotelsApiRepository
import com.example.shacklehotelbuddy.features.hotels.models.Hotel
import com.example.shacklehotelbuddy.features.search.db.ISearchParametersDbRepository
import javax.inject.Inject

class HotelsUseCase @Inject constructor(
    private val searchParametersDbRepository: ISearchParametersDbRepository,
    private val hotelsApiRepository: IHotelsApiRepository
) : ApiUseCase() {
    suspend fun getHotelsByLastRequest(): RequestResult<List<Hotel>> {
        searchParametersDbRepository.getLastSearchParameters(count = 1).firstOrNull()?.let { searchParameters ->
            return hotelsApiRepository.getHotels(searchParameters = searchParameters)
        } ?: return RequestResult.Failed(code = 0, errorMessage = "No search parameters found")
    }
}