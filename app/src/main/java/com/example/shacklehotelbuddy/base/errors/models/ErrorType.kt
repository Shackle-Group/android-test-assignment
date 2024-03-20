package com.example.shacklehotelbuddy.base.errors.models

enum class ErrorType(val errorCode: String) {
    ERROR_404("missing resource"),
    ERROR_500("internal server error"),

    // ... and etc for all errors from server to make translation easier.
}