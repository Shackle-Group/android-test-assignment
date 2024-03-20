package com.example.shacklehotelbuddy.base.api

import com.example.shacklehotelbuddy.base.api.models.RequestResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.json.JSONObject
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

const val HARDWARE_DISK_ERROR_CODE = 600
const val UNKNOWN_ERROR_CODE = 601

const val MESSAGE = "message"

abstract class BaseApiRepository {
    protected suspend inline fun <reified T> safeApiCall(
        crossinline apiToBeCalled: suspend () -> Response<T>
    ): RequestResult<T> = withContext(Dispatchers.IO) {
        try {
            val response: Response<T> = apiToBeCalled()
            if (response.isSuccessful) {
                RequestResult.Success(data = response.body()!!)
            } else {
                RequestResult.Failed(
                    code = response.code(),
                    errorMessage = response.getErrorMessage() ?: "Something went wrong"
                )
            }
        } catch (e: HttpException) {
            RequestResult.Failed(
                code = e.code(),
                errorMessage = e.message ?: "Please check your network connection"
            )
        } catch (e: IOException) {
            RequestResult.Failed(
                code = HARDWARE_DISK_ERROR_CODE,
                errorMessage = e.message ?: "Something went wrong"
            )
        } catch (e: Exception) {
            RequestResult.Failed(
                code = UNKNOWN_ERROR_CODE,
                errorMessage = e.message ?: "Something went wrong"
            )
        }
    }

    protected inline fun <reified T> Response<T>.getErrorMessage(): String? = try {
        val json = JSONObject(errorBody()?.string())
        val errorMessage = json[MESSAGE] as String
        errorMessage
    } catch (e: Exception) {
        null
    }
}