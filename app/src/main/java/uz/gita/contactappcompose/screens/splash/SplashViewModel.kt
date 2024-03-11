package uz.gita.contactappcompose.screens.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.viewmodel.container
import uz.gita.contactappcompose.data.model.StartScreenEnum
import uz.gita.contactappcompose.domain.IdentificationRepository
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val repository: IdentificationRepository,
    private val direction: SplashContract.Direction
) : SplashContract.ViewModel, ViewModel() {
    override val container =
        container<SplashContract.UIState, SplashContract.SideEffect>(SplashContract.UIState.InitState)

    override fun onEventDispatcher(intent: SplashContract.Intent) {}

    init {
        viewModelScope.launch {
            delay(3000)
            when (repository.startScreen()) {
                StartScreenEnum.Login -> direction.openLogInScreen()
                StartScreenEnum.Main -> direction.openMainScreen()
            }
        }
    }
}