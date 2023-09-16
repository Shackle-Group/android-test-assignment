package com.example.shacklehotelbuddy.core_network.di


import com.example.shacklehotelbuddy.core_network.BuildConfig
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideKotlinJson() = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }
    @Provides
    @Singleton
    fun provideKotlinSerialization(json: Json): Converter.Factory {
        val contentType = "application/json".toMediaType()
        return json.asConverterFactory(contentType)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient() = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        addInterceptor(
            Interceptor { chain ->
                val builder = chain.request().newBuilder()
                builder.header("X-RapidAPI-Key", BuildConfig.X_RapidAPI_Key)
                builder.header("X-RapidAPI-Host", BuildConfig.X_RapidAPI_Host)
                return@Interceptor chain.proceed(builder.build())
            }
        )
    }.build()

    @Provides
    @Singleton
    fun provideRetrofit(json: Json, okHttpClient: OkHttpClient, converter: Converter.Factory) =
        Retrofit.Builder().client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(CoroutineCallAdapterFactory()).baseUrl(BuildConfig.BASE_URL)
            .build()

}