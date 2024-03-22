package com.example.shacklehotelbuddy.base.api.models

sealed class RequestResult<T> {
    class Success<T>(val data: T?) : RequestResult<T>()

    class Failed<T>(val code: Int, val errorMessage: String) : RequestResult<T>()
}