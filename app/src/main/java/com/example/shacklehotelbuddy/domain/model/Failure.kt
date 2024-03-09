package com.example.shacklehotelbuddy.domain.model

sealed class Failure {
    object NetworkError: Failure()
    object ConnectionError: Failure()
    object ServerError: Failure()
}
