package com.example.shacklehotelbuddy.di

import com.example.shacklehotelbuddy.data.remote.service.HotelSearchService
import com.example.shacklehotelbuddy.domain.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    @Named(AppConstants.OKHTTP_REQUEST_HEADER_INTERCEPTOR)
    fun provideRequestInterceptor(): Interceptor = Interceptor { chain ->
        val request = chain.request()
            .newBuilder()
            .header(AppConstants.HEADER_RAPID_API_KEY, AppConstants.HEADER_API_KEY)
            .header(AppConstants.HEADER_RAPID_API_HOST, AppConstants.HEADER_HOST)
            .header(AppConstants.HEADER_CONTENT_TYPE, AppConstants.HEADER_CONTENT_TYPE_VALUE)
            .build()
        chain.proceed(request)
    }

    @Singleton
    @Provides
    fun provideOkHttpClient(
        @Named(AppConstants.OKHTTP_REQUEST_HEADER_INTERCEPTOR) requestInterceptor: Interceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl(AppConstants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Singleton
    @Provides
    fun provideHotelSearchService(retrofit: Retrofit): HotelSearchService = retrofit.create(
        HotelSearchService::class.java
    )
}