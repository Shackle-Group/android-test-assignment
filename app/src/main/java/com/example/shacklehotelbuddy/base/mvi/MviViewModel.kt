package com.example.shacklehotelbuddy.base.mvi

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

/**
 * Base view model for MVI-pattern.
 *
 * @param I Type of intents
 * @param S Type of states
 * @constructor Create empty constructor for mvi view model
 */
abstract class MviViewModel<I : IMviIntent, S : IMviState, A : IMviAction>(
    defaultState: S
) : ViewModel() {
    val state = MutableStateFlow(defaultState)
    open val action = MutableSharedFlow<A>()

    val currentState: S
        get() = state.value

    /**
     * Dispatch intent async.
     *
     * @param intent Intent
     */
    fun dispatchIntentAsync(intent: I) = viewModelScope.launch {
        withContext(Dispatchers.Default) {
            dispatchIntent(intent)
        }
    }

    /**
     * Dispatch an intent.
     *
     * @param intent Intent
     */
    protected open suspend fun dispatchIntent(intent: I) { }

    /**
     * Emit state.
     *
     * @receiver [S]
     */
    protected suspend fun S.emitState() = state.emit(this)

    /**
     * Emit action.
     *
     * @receiver [IMviAction]
     */
    protected suspend fun A.emitAction() = action.emit(this@emitAction)
}