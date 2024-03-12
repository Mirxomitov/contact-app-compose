package uz.gita.contactappcompose.screens.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.contactappcompose.data.model.remote.request.AddContactRequest
import uz.gita.contactappcompose.domain.ContactRepository
import uz.gita.contactappcompose.utils.NetworkStatusValidator
import uz.gita.contactappcompose.utils.logger
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(
    private val repository: ContactRepository,
    private val direction: AddDirection,
    private val networkStatusValidator: NetworkStatusValidator
) : ViewModel(), AddContract.ViewModel {
    override fun eventDispatcher(intent: AddContract.Intent) = intent {
        when (intent) {
            is AddContract.Intent.AddContact -> {
                if (!networkStatusValidator.hasNetwork) {
                    postSideEffect(AddContract.SideEffect.Toast("Not connection"))
                    return@intent
                }

                repository.addContact(
                    AddContactRequest(
                        firstName = intent.firstName,
                        lastName = intent.lastName,
                        phone = intent.phone
                    )
                ).onEach {
                    it.onSuccess {
                        postSideEffect(AddContract.SideEffect.ReloadEffect)
                        postSideEffect(AddContract.SideEffect.Toast("Successful"))
                        direction.back()
                    }
                    it.onFailure {
                        postSideEffect(AddContract.SideEffect.Toast("Error!"))
                        direction.back()
                    }
                }.launchIn(viewModelScope)
            }

            is AddContract.Intent.Back -> direction.back()
        }
    }

    override val container =
        container<AddContract.UIState, AddContract.SideEffect>(AddContract.UIState.InitState)
}