package uz.gita.contactappcompose.screens.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.contactappcompose.data.model.remote.request.RegisterRequestData
import uz.gita.contactappcompose.domain.IdentificationRepository
import uz.gita.contactappcompose.utils.logger
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val navigation: RegisterContract.Direction,
    private val repository: IdentificationRepository
) : RegisterContract.ViewModel, ViewModel() {
    override fun eventDispatcher(intent: RegisterContract.Intent) = intent {
        when (intent) {
            is RegisterContract.Intent.Register -> {
                repository
                    .register(
                        RegisterRequestData(
                            firstName = intent.firstName,
                            lastName = intent.lastName,
                            phone = intent.phone,
                            password = intent.password
                        )
                    )
                    .onEach {
                        it.onSuccess {
                            logger(it.message)
                            navigation.toVerifyScreen(intent.phone)
                        }
                        it.onFailure {
                            logger(it.message ?: "")

                        }
                    }
                    .launchIn(viewModelScope)
            }


            RegisterContract.Intent.Login -> {
                navigation.toLoginScreen()
            }
        }
    }

    override val container =
        container<RegisterContract.UIState, RegisterContract.SideEffect>(
            RegisterContract.UIState.InitState
        )
}
