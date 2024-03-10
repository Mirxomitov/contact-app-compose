package uz.gita.contactappcompose.screens.login

import uz.gita.contactappcompose.screens.main.MainScreen
import uz.gita.contactappcompose.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginDirections @Inject constructor(
    private val navigator: AppNavigator
) : LoginContract.Direction {
    override suspend fun toRegisterScreen() {
        //navigator.replace(RegisterScreen())
    }

    override suspend fun toMainScreen() {
        navigator.replace(MainScreen())
    }
}