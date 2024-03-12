package uz.gita.contactappcompose.screens.verify

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.contactappcompose.data.model.remote.request.VerifyRequestData
import uz.gita.contactappcompose.domain.IdentificationRepository
import javax.inject.Inject

@HiltViewModel
class VerifyViewModel @Inject constructor(
    private val repository: IdentificationRepository,
    private val navigation: VerifyContract.Direction
) : VerifyContract.ViewModel, ViewModel() {
    override fun eventDispatcher(intent: VerifyContract.Intent) = intent {
        when (intent) {
            is VerifyContract.Intent.CheckCode -> {
                repository.checkSMSCode(
                    VerifyRequestData(
                        code = intent.code,
                        phone = intent.phone
                    )
                ).onEach {
                    it.onSuccess {
                        repository.saveToken(it.token)
                        navigation.toMainScreen()
                    }
                    it.onFailure {
                        navigation.back()
                    }
                }.launchIn(viewModelScope)
            }
        }
    }

    override val container =
        container<VerifyContract.UIState, VerifyContract.SideEffect>(
            VerifyContract.UIState.InitState
        )
}