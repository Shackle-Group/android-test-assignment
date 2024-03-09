package com.example.shacklehotelbuddy.data.remote.service

import com.example.shacklehotelbuddy.data.remote.model.BookingHotelSearchResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

const val API_PROPERTIES_LIST = "v1/hotels/search?order_by=popularity&filter_by_currency=AED&locale=en-gb&units=metric&dest_id=-553173&dest_type=city&room_number=1&include_adjacency=true&page_number=0&categories_filter_ids=class%3A%3A2%2Cclass%3A%3A4%2Cfree_cancellation%3A%3A1&children_ages=5%2C0"
//const val API_PROPERTIES_LIST = "properties/v2/list"

interface HotelSearchService {

    @GET(API_PROPERTIES_LIST)
    suspend fun searchHotels(
        @Query("checkin_date") checkInDate: String,
        @Query("checkout_date") checkOutDate: String,
        @Query("adults_number") adults: String,
        @Query("children_number") children: String
    ): Response<BookingHotelSearchResponse?>

//    @POST(API_PROPERTIES_LIST)
//    suspend fun searchHotels(@Body request: HotelSearchRequest): Response<HotelSearchResponse?>
}