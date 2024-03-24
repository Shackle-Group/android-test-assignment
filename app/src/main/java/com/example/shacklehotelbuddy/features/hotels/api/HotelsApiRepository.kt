package com.example.shacklehotelbuddy.features.hotels.api

import com.example.shacklehotelbuddy.base.api.BaseApiRepository
import com.example.shacklehotelbuddy.base.api.models.RequestResult
import com.example.shacklehotelbuddy.features.hotels.api.request.CheckDateRequest
import com.example.shacklehotelbuddy.features.hotels.api.request.ChildRequest
import com.example.shacklehotelbuddy.features.hotels.api.request.HotelSearchRequest
import com.example.shacklehotelbuddy.features.hotels.api.request.RoomRequest
import com.example.shacklehotelbuddy.features.hotels.api.responses.HotelSearchResponse
import com.example.shacklehotelbuddy.features.hotels.models.Hotel
import com.example.shacklehotelbuddy.features.hotels.models.SearchParameters
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Provides list of hotels by search parameters.
 *
 * @property hotelsApiService Provides access to the server
 * @constructor Create [HotelsApiRepository]
 */
@Singleton
class HotelsApiRepository @Inject constructor(
    private val hotelsApiService: HotelsApiService
) : BaseApiRepository(), IHotelsApiRepository {
    override suspend fun getHotels(searchParameters: SearchParameters): RequestResult =
        executeRequestAndGetResult(
            requestAction = { hotelsApiService.getHotels(getHotelSearchRequest(searchParameters = searchParameters)) },
            mappingAction = { it?.convertToHotels() ?: emptyList() }
        )

    /**
     * Convert [SearchParameters] to [HotelSearchRequest]-stub.
     *
     * @param searchParameters Search parameters
     * @return [HotelSearchRequest]
     */
    private fun getHotelSearchRequest(searchParameters: SearchParameters) = with(searchParameters) {
        HotelSearchRequest.getStubInstance(
            checkInDate = getCheckDateRequest(timestamp = checkInTimestamp),
            checkOutDate = getCheckDateRequest(timestamp = checkOutTimestamp),
            rooms = listOf(
                RoomRequest(
                    adults = adultCount.toLong(),
                    children = ArrayList<ChildRequest>().apply {
                        repeat(childrenCount) { add(ChildRequest(age = 5)) }
                    }
                )
            )
        )
    }

    /**
     * Get check date request.
     *
     * @param timestamp Timestamp
     * @return [CheckDateRequest]
     */
    private fun getCheckDateRequest(timestamp: Long) = with(Calendar.getInstance()) {
        timeInMillis = timestamp
        CheckDateRequest(
            day = get(Calendar.DAY_OF_MONTH).toLong(),
            month = get(Calendar.MONTH).toLong(),
            year = get(Calendar.YEAR).toLong()
        )
    }

    /**
     * Convert to hotels.
     *
     * @receiver [HotelSearchResponse]
     * @return
     */
    private fun HotelSearchResponse.convertToHotels() =
        this.data?.propertySearch?.properties?.map {
            Hotel(
                id = it.id,
                name = it.name,
                url = it.propertyImage.image.url,
                price = it.price.options.first().formattedDisplayPrice,
                location = it.neighborhood.name,
                rating = it.reviews.score,
            )
        }
}