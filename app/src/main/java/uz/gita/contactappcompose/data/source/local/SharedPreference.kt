package uz.gita.contactappcompose.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SharedPreference @Inject constructor(
    private val preferences: SharedPreferences
) {
    fun saveToken(token: String): Unit =
        preferences.edit().putString("TOKEN", token).apply()

    fun getToken(): String = preferences.getString("TOKEN", "LOGIN")!!
}