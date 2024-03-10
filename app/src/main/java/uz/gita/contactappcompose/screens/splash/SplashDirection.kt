package uz.gita.contactappcompose.screens.splash

import uz.gita.contactappcompose.screens.login.LogInScreen
import uz.gita.contactappcompose.utils.navigation.AppNavigator
import uz.gita.contactappcompose.screens.main.MainScreen
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SplashDirection @Inject constructor(
    private val navigator: AppNavigator
) : SplashContract.Direction {
    override suspend fun openMainScreen() {
        navigator.replace(MainScreen())
    }

    override suspend fun openLogInScreen() {
        navigator.replace(LogInScreen())
    }
}