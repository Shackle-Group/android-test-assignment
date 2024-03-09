package com.example.shacklehotelbuddy.data.local.datasource

import com.example.shacklehotelbuddy.data.mock.MockHotelSearch
import com.example.shacklehotelbuddy.domain.local.datasource.HotelLocalDataSource
import com.example.shacklehotelbuddy.domain.model.HotelSearch
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class HotelLocalDataSourceImplTest @Inject constructor() : HotelLocalDataSource {

    override suspend fun cacheHotelSearch(hotelSearch: HotelSearch) {

    }

    override suspend fun getCachedHotelSearches(): Flow<List<HotelSearch>> {
        return flow { emit(MockHotelSearch.hotelSearchList) }
    }

}
