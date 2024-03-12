package uz.gita.contactappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.contactappcompose.utils.navigation.AppNavigationHandler
import uz.gita.contactappcompose.utils.navigation.AppNavigator
import uz.gita.contactappcompose.utils.navigation.AppNavigatorDispatcher

@Module
@InstallIn(SingletonComponent::class)
interface NavigationModule {
    @Binds
    fun bindNavigation(dispatcher: AppNavigatorDispatcher): AppNavigator

    @Binds
    fun bindHandler(dispatcher: AppNavigatorDispatcher): AppNavigationHandler


}