package uz.gita.contactappcompose.screens.add

import uz.gita.contactappcompose.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AddDirection @Inject constructor(
    private val navigator: AppNavigator
) : AddContract.Direction {
    override suspend fun back() {
        navigator.pop()
    }
}