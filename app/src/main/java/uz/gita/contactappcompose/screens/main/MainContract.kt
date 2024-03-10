package uz.gita.contactappcompose.screens.main

import org.orbitmvi.orbit.ContainerHost
import uz.gita.contactappcompose.data.model.ContactUIData

interface MainContract {
    interface ViewModel : ContainerHost<UIState, SideEffect>{
        fun onEventDispatchers(intent: Intent)
        fun loadContacts()
    }

    interface SideEffect {}
    interface UIState {
        object EmptyState: UIState
        data class Contacts(
            val isLoading : Boolean,
            val contacts : List<ContactUIData>
        ) : UIState
    }
    interface Intent {
        object Reload : Intent
        object AddContact : Intent
        data class EditContact(val contact : ContactUIData) : Intent
    }

    interface Direction {
        suspend fun openAddContact()
        suspend fun openEditContact()
    }
}