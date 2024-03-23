package com.example.shacklehotelbuddy.base.api.models


/**
 * Result class for requests. It can be success or error.
 *
 * @param T Type of response data
 * @constructor Create empty constructor for resource
 */
sealed class RequestResult<T> {
    /**
     * We'll wrap our data in this 'Success' class in case of success response from api.
     *
     * @param T Type of response
     * @property data Response
     * @constructor Create [Success]
     */
    class Success<T>(val data: T?) : RequestResult<T>()

    /**
     * We'll pass error message wrapped in this 'Error' class to the UI in case of failure response.
     *
     * @param T Type of response
     * @property code Error code
     * @property errorMessage Text of error
     * @constructor Create [Failed]
     */
    class Failed<T>(val code: Int, val errorMessage: String) : RequestResult<T>()
}