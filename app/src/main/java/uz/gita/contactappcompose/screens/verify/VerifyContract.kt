package uz.gita.contactappcompose.screens.verify

import org.orbitmvi.orbit.ContainerHost

interface VerifyContract {
    interface ViewModel : ContainerHost<UIState, SideEffect> {
        fun eventDispatcher(intent: Intent)
    }

    interface UIState {
        data object InitState : UIState

    }

    interface SideEffect
    interface Intent {
        data class CheckCode(val code : String, val phone : String,   ) : Intent
    }

    interface Direction {
        suspend fun toMainScreen()
        suspend fun back()
    }
}