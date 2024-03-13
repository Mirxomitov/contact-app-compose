package uz.gita.contactappcompose.screens.edit

import org.orbitmvi.orbit.ContainerHost
import uz.gita.contactappcompose.data.model.ContactUIData

interface EditContract {
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
        data class EditContact(val data: ContactUIData) : Intent
    }

    interface Direction {
        suspend fun back()
    }
}