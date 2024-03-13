package uz.gita.contactappcompose.screens.edit

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.contactappcompose.domain.ContactRepository
import uz.gita.contactappcompose.utils.NetworkStatusValidator
import uz.gita.contactappcompose.utils.mapper.toEditContactRequest
import javax.inject.Inject

@HiltViewModel
class EditViewModel @Inject constructor(
    private val repository: ContactRepository,
    private val direction: EditDirection,
    private val networkStatusValidator: NetworkStatusValidator
) : ViewModel(), EditContract.ViewModel {
    override fun eventDispatcher(intent: EditContract.Intent) = intent {
        when (intent) {
            is EditContract.Intent.EditContact -> {
                if (!networkStatusValidator.hasNetwork) {
                    postSideEffect(EditContract.SideEffect.Toast("Not connection"))
                    return@intent
                }

                repository.editContact(intent.data.toEditContactRequest()).onEach {
                    it.onSuccess {
                        postSideEffect(EditContract.SideEffect.ReloadEffect)
                        postSideEffect(EditContract.SideEffect.Toast("Successful"))
                        direction.back()
                    }
                    it.onFailure {
                        postSideEffect(EditContract.SideEffect.Toast("Error!"))
                        direction.back()
                    }
                }.launchIn(viewModelScope)
            }

            is EditContract.Intent.Back -> direction.back()
        }
    }

    override val container =
        container<EditContract.UIState, EditContract.SideEffect>(EditContract.UIState.InitState)
}