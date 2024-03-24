package com.example.shacklehotelbuddy.syntaxSugar

import com.example.shacklehotelbuddy.base.api.models.RequestResult
import org.junit.Assert.assertEquals

/**
 * Check negative result.
 *
 * @param T Type of response
 * @receiver [RequestResult]
 */
fun <T> RequestResult<T>.checkNegativeResult() {
    if (this !is RequestResult.Failed) {
        throw IllegalArgumentException("Result is not failed")
    }
    assertEquals("timeout", this.errorMessage)
    assertEquals(404, code)
}