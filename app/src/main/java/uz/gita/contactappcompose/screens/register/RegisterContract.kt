package uz.gita.contactappcompose.screens.register

import org.orbitmvi.orbit.ContainerHost

interface RegisterContract {
    interface UIState {
        object InitState : UIState
    }

    interface SideEffect {}
    interface Intent {
        data class Register(
            val firstName: String,
            val lastName: String,
            val phone: String,
            val password: String
        ) : Intent

        data object Login : Intent
    }

    interface Direction {
        suspend fun toLoginScreen()
        suspend fun toVerifyScreen(phone : String)
    }

    interface ViewModel : ContainerHost<UIState, SideEffect> {
        fun eventDispatcher(intent: Intent)
    }
}