package com.example.shacklehotelbuddy.syntaxSugar

import android.content.Context
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.After
import org.junit.Assert.fail
import org.junit.Before

const val ONE_SECOND = 1000L

/**
 * Base android unit test.
 *
 * @constructor Create empty constructor for base android unit test
 */
abstract class BaseAndroidUnitTest {
    protected val targetContext: Context = InstrumentationRegistry.getInstrumentation().targetContext

    /**
     * Before test.
     */
    @Before
    open fun beforeTest() { }

    /**
     * After test.
     */
    @After
    open fun afterTest() { }

    /**
     * Assert throws.
     *
     * @param T Exception type
     * @param runnable Runnable
     */
    inline fun <reified T : Exception> assertThrows(runnable: () -> Any?) {
        try {
            runnable.invoke()
        } catch (e: Throwable) {
            if (e is T) {
                return
            }
            fail("expected ${T::class.qualifiedName} but caught ${e::class.qualifiedName} instead")
        }
        fail("expected ${T::class.qualifiedName}")
    }
}