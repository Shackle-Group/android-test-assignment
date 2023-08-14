package com.adrianczuczka.data.properties

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.adrianczuczka.data.properties.remote.PropertiesService
import com.adrianczuczka.data.properties.remote.model.ApiProperty
import com.adrianczuczka.data.properties.remote.model.ApiSearchInfo
import com.adrianczuczka.data.properties.remote.model.request.GetPropertiesRequest

class PropertiesPagingSource(
    private val service: PropertiesService,
    private val apiSearchInfo: ApiSearchInfo,
) : PagingSource<Int, ApiProperty>() {

    override suspend fun load(
        params: LoadParams<Int>,
    ): LoadResult<Int, ApiProperty> =
        try {
            val nextPageNumber = params.key ?: 0
            val response = service.getProperties(
                GetPropertiesRequest(
                    destination = apiSearchInfo.destination,
                    checkInDate = apiSearchInfo.checkInDate,
                    checkOutDate = apiSearchInfo.checkOutDate,
                    rooms = apiSearchInfo.rooms,
                    resultsStartingIndex = nextPageNumber,
                )
            ).data.propertySearch
            LoadResult.Page(
                data = response.properties,
                prevKey = null,
                nextKey = nextPageNumber + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }

    override fun getRefreshKey(state: PagingState<Int, ApiProperty>): Int? =
        state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
}