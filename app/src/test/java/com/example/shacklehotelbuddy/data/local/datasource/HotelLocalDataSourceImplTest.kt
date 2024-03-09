package com.example.shacklehotelbuddy.data.local.datasource

import com.example.shacklehotelbuddy.domain.local.datasource.HotelLocalDataSource
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HotelLocalDataSourceImplTest @Inject constructor() : HotelLocalDataSource {
    override suspend fun cacheHotelSearch(hotelSearch: HotelSearch) {
        TODO("Not yet implemented")
    }

    override suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>> {
        TODO("Not yet implemented")
    }

}
