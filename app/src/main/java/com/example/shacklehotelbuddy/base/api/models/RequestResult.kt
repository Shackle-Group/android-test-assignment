package com.example.shacklehotelbuddy.base.api.models


/**
 * Result class for requests. It can be success or error.
 *
 * @param T Type of response data
 * @constructor Create empty constructor for resource
 */
sealed interface RequestResult {
    /**
     * We'll wrap our data in this 'Success' class in case of success response from api.
     *
     * @param T Type of response
     * @property data Response
     * @constructor Create [Success]
     */
    data class Success<T>(val data: T?) : RequestResult

    /**
     * We'll pass error message wrapped in this 'Error' class to the UI in case of failure response.
     *
     * @param T Type of response
     * @property code Error code
     * @property errorMessage Text of error
     * @constructor Create [Failed]
     */
    data class Failed(val code: Int, val errorMessage: String) : RequestResult
}