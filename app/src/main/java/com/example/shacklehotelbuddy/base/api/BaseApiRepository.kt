package com.example.shacklehotelbuddy.base.api

import com.example.shacklehotelbuddy.base.api.models.RequestResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response

const val UNKNOWN_ERROR_CODE = 601

/**
 * Base api repository for all REST-API repositories.
 *
 * @constructor Create empty constructor for base api repository
 */
abstract class BaseApiRepository {
    /**
     * Execute request and get result.
     *
     * @param T Response type
     * @param R Data layer output type
     * @param requestAction Request action
     * @param mappingAction Mapping action
     * @return [RequestResult]
     */
    protected suspend inline fun <reified T, reified R> executeRequestAndGetResult(
        crossinline requestAction: suspend () -> Response<T>,
        crossinline mappingAction: (data: T?) -> R
    ): RequestResult = try {
        withContext(Dispatchers.IO) {
            val response = requestAction.invoke()
            if (response.isSuccessful) {
                RequestResult.Success(mappingAction(response.body()))
            } else {
                RequestResult.Failed(
                    response.code(),
                    response.errorBody()?.string() ?: "missing error message"
                )
            }
        }
    }  catch (e: HttpException) {
        RequestResult.Failed(
            code = e.code(),
            errorMessage = e.message ?: "Please check your network connection"
        )
    } catch (e: Exception) {
        RequestResult.Failed(
            code = UNKNOWN_ERROR_CODE,
            errorMessage = e.message ?: "Something went wrong"
        )
    }
}