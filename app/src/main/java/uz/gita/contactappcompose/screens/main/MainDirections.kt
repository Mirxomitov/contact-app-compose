package uz.gita.contactappcompose.screens.main

import uz.gita.contactappcompose.screens.add.AddScreen
import uz.gita.contactappcompose.screens.edit.EditScreen
import uz.gita.contactappcompose.utils.navigation.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainDirections @Inject constructor(
    private val navigator: AppNavigator
) : MainContract.Direction {
    override suspend fun openAddContact() {
        navigator.push(AddScreen())
    }

    override suspend fun openEditContact() {
        navigator.push(EditScreen())
    }
}