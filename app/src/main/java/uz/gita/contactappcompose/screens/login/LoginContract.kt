package uz.gita.contactappcompose.screens.login

import org.orbitmvi.orbit.ContainerHost

interface LoginContract {
    interface UIState {
        object InitState : UIState
        object LoginEnabled : UIState
    }

    interface SideEffect {}
    interface Intent {
        data class Login(val phone: String, val password: String) : Intent
        data object Register : Intent
        data object LoginEnabled : Intent
    }

    interface Direction {
        suspend fun toRegisterScreen()
        suspend fun toMainScreen()
    }

    interface ViewModel : ContainerHost<UIState, SideEffect> {
        fun eventDispatcher(intent: Intent)
    }
}