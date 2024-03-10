package uz.gita.contactappcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.lifecycleScope
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import uz.gita.contactappcompose.screens.splash.SplashScreen
import uz.gita.contactappcompose.ui.theme.ContactAppComposeTheme
import uz.gita.contactappcompose.utils.NetworkStatusValidator
import uz.gita.contactappcompose.utils.navigation.AppNavigationHandler
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var handler: AppNavigationHandler

    @Inject
    lateinit var networkStatusValidator: NetworkStatusValidator

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        networkStatusValidator.init(
            availableNetworkBlock = {},
            lostConnection = {}
        )

        setContent {
            ContactAppComposeTheme {
                Navigator(SplashScreen()) { navigator ->
                    LaunchedEffect(key1 = Unit) {
                        handler
                            .backStack
                            .onEach { it(navigator) }
                            .launchIn(lifecycleScope)
                    }
                    CurrentScreen()
                }
            }
        }
    }
}