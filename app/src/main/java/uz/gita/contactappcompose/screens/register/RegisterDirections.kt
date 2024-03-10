package uz.gita.contactappcompose.screens.register

import uz.gita.contactappcompose.screens.login.LogInScreen
import uz.gita.contactappcompose.screens.main.MainScreen
import uz.gita.contactappcompose.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RegisterDirections @Inject constructor(
    private val navigator: AppNavigator
) : RegisterContract.Direction {
    override suspend fun toLoginScreen() {
        navigator.replace(LogInScreen())
    }

    override suspend fun toMainScreen() {
        navigator.replace(MainScreen())
    }
}