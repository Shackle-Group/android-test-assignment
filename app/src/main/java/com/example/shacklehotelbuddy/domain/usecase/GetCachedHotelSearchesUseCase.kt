package com.example.shacklehotelbuddy.domain.usecase

import com.example.shacklehotelbuddy.domain.repository.HotelRepository
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class GetCachedHotelSearchesUseCase @Inject constructor(private val repository: HotelRepository) {

    suspend operator fun invoke(): Flow<List<HotelSearch>> = repository.getCachedHotelSearches()
}