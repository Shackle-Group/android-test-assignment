package com.example.shacklehotelbuddy.base.mvi

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.basetrack.btcodriver.base.mvi.models.MviViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.plus

/**
 * MVI-fragment promises to implement states for at least one viewModel.
 *
 * @param I Group of input-intents for viewModel
 * @param S Group of output-states from viewModel
 * @param A Group of output-single-actions from viewModel
 * @param VM ViewModel
 * @constructor Create empty constructor for mvi fragment
 */
abstract class MviFragment<I : IMviIntent, S : IMviState, A : IMviAction, VM : MviViewModel<I, S, A>> : Fragment() {
    private var stateAndActionScope: CoroutineScope? = null
    protected abstract val viewModel: VM

    final override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (lifecycleScope + Job()).apply {
            viewModel.action.onEach(::executeSingleAction).launchIn(this)
            stateAndActionScope = this
        }
    }

    /**
     * Execute single action.
     *
     * @param action Mvi action
     */
    protected open fun executeSingleAction(action: A) {}

    /**
     * Emit intent.
     *
     * @receiver [I]
     */
    protected open fun I.dispatchIntent() = viewModel.dispatchIntentAsync(this)

    override fun onDestroyView() {
        super.onDestroyView()
        stateAndActionScope?.cancel()
    }
}