package uz.gita.contactappcompose.utils.navigation

import kotlinx.coroutines.flow.MutableSharedFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppNavigatorDispatcher @Inject constructor() : AppNavigator, AppNavigationHandler {
    override val backStack = MutableSharedFlow<AppNavigationArgs>()

    private suspend fun navigator(arg: AppNavigationArgs) {
        backStack.emit(arg)
    }

    override suspend fun pop() = navigator {
        this.pop()
    }

    override suspend fun popAll() = navigator {
        this.popAll()
    }

    override suspend fun push(screen: AndroidScreen) = navigator {
        this.push(screen)
    }

    override suspend fun replace(screen: AndroidScreen) = navigator {
        replace(screen)
    }
}