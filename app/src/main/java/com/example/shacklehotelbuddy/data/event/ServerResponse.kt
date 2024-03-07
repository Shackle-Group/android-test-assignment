package com.example.shacklehotelbuddy.data.event

sealed class ServerResponse<out R> {
    data class Error(val error: String) : ServerResponse<Nothing>()
    data class Success<out T>(val data: T) : ServerResponse<T>()
}
