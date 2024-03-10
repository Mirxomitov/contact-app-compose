package uz.gita.contactappcompose.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import uz.gita.contactappcompose.screens.login.LoginContract
import uz.gita.contactappcompose.screens.login.LoginDirections
import uz.gita.contactappcompose.screens.main.MainContract
import uz.gita.contactappcompose.screens.main.MainDirections
import uz.gita.contactappcompose.screens.register.RegisterContract
import uz.gita.contactappcompose.screens.register.RegisterDirections
import uz.gita.contactappcompose.screens.splash.SplashContract
import uz.gita.contactappcompose.screens.splash.SplashDirection

@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
    @Binds
    fun bindSplashDirection(direction: SplashDirection): SplashContract.Direction

    @Binds
    fun bindMainDirection(direction: MainDirections): MainContract.Direction

    @Binds
    fun bindLoginDirection(direction: LoginDirections): LoginContract.Direction

    @Binds
    fun bindRegisterDirection(direction: RegisterDirections): RegisterContract.Direction
}