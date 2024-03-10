package uz.gita.contactappcompose.screens.main

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.contactappcompose.domain.ContactRepository
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ContactRepository,
    private val direction: MainContract.Direction
) : MainContract.ViewModel, ViewModel() {

    init {
        loadContacts()
    }

    override fun onEventDispatchers(intent: MainContract.Intent) = intent {
        when (intent) {
            MainContract.Intent.AddContact -> {}
            is MainContract.Intent.EditContact -> {}
            is MainContract.Intent.Reload -> {}
        }
    }

    override fun loadContacts() {

    }

    override val container =
        container<MainContract.UIState, MainContract.SideEffect>(MainContract.UIState.EmptyState)
}