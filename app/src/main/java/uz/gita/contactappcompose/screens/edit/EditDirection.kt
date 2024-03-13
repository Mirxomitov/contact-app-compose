package uz.gita.contactappcompose.screens.edit

import uz.gita.contactappcompose.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EditDirection @Inject constructor(
    private val navigator: AppNavigator
) : EditContract.Direction {
    override suspend fun back() {
        navigator.pop()
    }
}