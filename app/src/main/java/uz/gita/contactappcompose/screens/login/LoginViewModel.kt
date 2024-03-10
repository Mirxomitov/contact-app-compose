package uz.gita.contactappcompose.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.contactappcompose.data.model.remote.request.LogInRequestData
import uz.gita.contactappcompose.domain.IdentificationRepository
import uz.gita.contactappcompose.utils.logger
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val navigation: LoginContract.Direction,
    private val repository: IdentificationRepository
) : LoginContract.ViewModel, ViewModel() {
    override fun eventDispatcher(intent: LoginContract.Intent) = intent {
        when (intent) {
            is LoginContract.Intent.Login -> {
                repository
                    .login(
                        LogInRequestData(
                            intent.phone,
                            intent.password
                        )
                    )
                    .onEach {
                        it.onSuccess {
                            repository.saveToken(it.token)
                            navigation.toMainScreen()
                        }
                        it.onFailure {
                            logger(it.message ?: "")
                        }
                    }
                    .launchIn(viewModelScope)
            }


            LoginContract.Intent.Register -> {}
        }
    }

    override val container =
        container<LoginContract.UIState, LoginContract.SideEffect>(
            LoginContract.UIState.InitState
        )
}
