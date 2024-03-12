package uz.gita.contactappcompose.screens.verify

import cafe.adriel.voyager.navigator.Navigator
import uz.gita.contactappcompose.screens.main.MainScreen
import uz.gita.contactappcompose.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VerifyDirection @Inject constructor(
    private val navigator: AppNavigator
) : VerifyContract.Direction {
    override suspend fun toMainScreen() {
        navigator.push(MainScreen())
    }

    override suspend fun back() {
        navigator.pop()
    }
}