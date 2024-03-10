package com.example.shacklehotelbuddy.domain.usecase

import com.example.shacklehotelbuddy.data.remote.model.NetworkError
import com.example.shacklehotelbuddy.domain.core.Either
import com.example.shacklehotelbuddy.domain.model.hotelsearch.Hotel
import com.example.shacklehotelbuddy.domain.model.hotelsearch.HotelSearch
import com.example.shacklehotelbuddy.domain.repository.HotelRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchHotelsUseCase @Inject constructor(private val repository: HotelRepository) {

    suspend operator fun invoke(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, NetworkError>> {
        return repository.searchHotels(hotelSearch)
    }
}