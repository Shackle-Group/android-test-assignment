package com.example.shacklehotelbuddy.data.remote.model

private const val ERROR_AUTHENTICATION = "Failed to authenticate"
private const val ERROR_INVALID_REQUEST = "Bad request"
private const val ERROR_UNAUTHORIZED = "Unauthorized"
private const val ERROR_CONNECTION = "Connection Error"
private const val ERROR_CONNECTION_TIMEOUT = "Connection Timeout"
private const val ERROR_SERVER_INTERNAL = "Something went wrong"
private const val ERROR_SERVER_TEMPORARY_UNAVAILABLE = "Server is temporarily unavailable."
private const val ERROR_SERVER_MAINTENANCE = "Technical works are in progress."

abstract class BaseError(message: String = "") : Throwable(message)

sealed class NetworkError(errorMessage: String, cause: Throwable? = null) : BaseError(errorMessage) {
    object Authentication : NetworkError(ERROR_AUTHENTICATION)
    object InvalidRequest : NetworkError(ERROR_INVALID_REQUEST)
    object Unauthorized : NetworkError(ERROR_UNAUTHORIZED)
    object Connection : NetworkError(ERROR_CONNECTION)
    object ConnectionTimeout : NetworkError(ERROR_CONNECTION_TIMEOUT)
    object ServerInternalError : NetworkError(ERROR_SERVER_INTERNAL)
    object ServerTemporaryUnavailable : NetworkError(ERROR_SERVER_TEMPORARY_UNAVAILABLE)
    object ServerMaintenance : NetworkError(ERROR_SERVER_MAINTENANCE)
    data class OperationCode(val opCode: String, val responseCode: Int) : NetworkError(opCode)
    data class Unknown(val errorMessage: String = "") : NetworkError(errorMessage)
}