package uz.gita.contactappcompose.utils.navigation

import cafe.adriel.voyager.core.screen.Screen

interface AppNavigator {
    suspend fun pop()
    suspend fun popAll()
    suspend fun push(screen: AndroidScreen)
    suspend fun replace(screen: AndroidScreen)
}

typealias AndroidScreen = Screen