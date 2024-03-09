package com.example.shacklehotelbuddy.domain.usecase

import com.example.shacklehotelbuddy.data.repository.HotelRepository
import com.example.shacklehotelbuddy.domain.model.Either
import com.example.shacklehotelbuddy.domain.model.Failure
import com.example.shacklehotelbuddy.domain.model.Hotel
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchHotelsUseCase @Inject constructor(private val repository: HotelRepository) {

    suspend operator fun invoke(hotelSearch: HotelSearch): Flow<Either<List<Hotel>, Failure>> {
        return repository.searchHotels(hotelSearch)
    }
}