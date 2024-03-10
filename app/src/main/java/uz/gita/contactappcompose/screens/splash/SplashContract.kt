package uz.gita.contactappcompose.screens.splash

import org.orbitmvi.orbit.ContainerHost

interface SplashContract {
    interface SideEffect {}

    interface ViewModel : ContainerHost<UIState, SideEffect> {
        fun onEventDispatcher(intent: Intent)
    }

    interface Intent {

    }

    interface UIState {
        data object InitState : UIState
    }

    interface Direction {
        suspend fun openMainScreen()
        suspend fun openLogInScreen()
    }
}