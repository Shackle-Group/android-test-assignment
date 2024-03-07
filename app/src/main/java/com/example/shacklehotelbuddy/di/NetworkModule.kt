package com.example.shacklehotelbuddy.di

import ShackleHotelBuddy.BuildConfig
import com.example.shacklehotelbuddy.data.api.ApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitApiModule {
    @Provides
    fun provideBaseUrl() = BuildConfig.BaseURL

    @Provides
    @Singleton
    fun provideLoggingInterceptor() =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides
    @Singleton
    fun provideApiInterceptor() = Interceptor {
        val originalRequest = it.request()
        val newHttpUrl = originalRequest.url.newBuilder() // add api key here as query parameter...
            .build()
        val newRequest = originalRequest.newBuilder()
            .url(newHttpUrl)
            .build()
        it.proceed(newRequest)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        logging: HttpLoggingInterceptor,
        apiInterceptor: Interceptor
    ): OkHttpClient =
        OkHttpClient.Builder()
            .addInterceptor(HeaderInterceptor())
            .addNetworkInterceptor(apiInterceptor)
            .connectTimeout(20, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(logging)
            .build()


    @Provides
    @Singleton
    fun provideRetrofit(client: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BaseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(client)
        .build()

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)
}