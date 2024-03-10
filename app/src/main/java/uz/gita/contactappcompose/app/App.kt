package uz.gita.contactappcompose.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        // Timber.plant(Timber.DebugTree())
    }
}