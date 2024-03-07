package com.example.shacklehotelbuddy.di

import ShackleHotelBuddy.BuildConfig
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import okio.IOException

class HeaderInterceptor : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var newRequest: Request = chain.request()
        newRequest = newRequest.newBuilder()
            .addHeader(
                "X-RapidAPI-Key",
                BuildConfig.XRapidAPIKey
            )
            .addHeader(
                "X-RapidAPI-Host",
                BuildConfig.XRapidAPIHost
            )
            .build()
        return chain.proceed(newRequest)
    }

}