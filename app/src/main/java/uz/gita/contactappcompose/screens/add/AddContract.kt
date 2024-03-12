package uz.gita.contactappcompose.screens.add

import org.orbitmvi.orbit.ContainerHost

interface AddContract {
    interface ViewModel : ContainerHost<UIState, SideEffect> {
        fun eventDispatcher(intent: Intent)
    }

    interface SideEffect {
        object ReloadEffect : SideEffect
        data class Toast(val message: String) : SideEffect
    }

    interface UIState {
        object InitState : UIState
    }

    interface Intent {
        object Back : Intent
        data class AddContact(
            val firstName: String,
            val lastName: String,
            val phone: String,
        ) : Intent
    }

    interface Direction {
        suspend fun back()
    }
}