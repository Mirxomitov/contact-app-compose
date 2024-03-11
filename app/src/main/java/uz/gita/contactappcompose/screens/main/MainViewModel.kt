package uz.gita.contactappcompose.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.contactappcompose.domain.ContactRepository
import uz.gita.contactappcompose.utils.logger
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: ContactRepository,
    private val navigator: MainContract.Direction
) : MainContract.ViewModel, ViewModel() {

    init {
        loadContacts()
    }

    override fun onEventDispatchers(intent: MainContract.Intent) = intent {
        when (intent) {
            MainContract.Intent.AddContact -> {
                navigator.openAddContact()
            }
            is MainContract.Intent.EditContact -> {
                navigator.openEditContact()
            }
            is MainContract.Intent.Reload -> {
                loadContacts()
            }
            is MainContract.Intent.OpenBottomDialog -> {
                postSideEffect(MainContract.SideEffect.OpenBottomDialog(intent.contact))
            }
        }
    }

    override fun loadContacts() {
        repository.loadContacts().onEach {
            it.onSuccess {
                logger("SUCCESS")
                intent {
                    reduce {
                        MainContract.UIState.Contacts(
                            isLoading = false,
                            contacts = it
                        )
                    }
                }
            }
            it.onFailure {
                logger("repository.loadContacts() ${it.message}")
            }
        }.launchIn(viewModelScope)
    }

    override val container =
        container<MainContract.UIState, MainContract.SideEffect>(MainContract.UIState.EmptyState)
}