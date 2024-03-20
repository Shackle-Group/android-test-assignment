package com.example.shacklehotelbuddy.base.errors

import com.example.shacklehotelbuddy.base.api.models.RequestResult
import com.example.shacklehotelbuddy.base.errors.models.ErrorType
import com.example.shacklehotelbuddy.utils.IUseCase
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ErrorHandlingUseCase @Inject constructor() : IUseCase {
    // Here can be located more complex logic with error codes and etc.
    fun getErrorCode(code: Int, errorMessage: String): ErrorType = ErrorType.valueOf(errorMessage)

    companion object {
        suspend fun <T, R> RequestResult<T>.processRequestResult(
            action: (suspend (data: T) -> R),
            failAction: (suspend (code: Int, message: String) -> Unit)
        ) {
            when (this) {
                is RequestResult.Success -> action.invoke(data!!)
                is RequestResult.Failed -> failAction(code, errorMessage)
            }
        }
    }
}