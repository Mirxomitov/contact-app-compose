package uz.gita.contactappcompose.screens.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.view.KeyEventDispatcher
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.contactappcompose.R
import uz.gita.contactappcompose.ui.theme.ContactAppComposeTheme

class SplashScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<SplashViewModel>()
        SplashContent(viewModel.collectAsState().value, viewModel::onEventDispatcher)
    }
}

@Composable
fun SplashContent(uiState: SplashContract.UIState, eventDispatcher: (SplashContract.Intent) -> Unit) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier.align(Alignment.Center),
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = "default"
        )
    }
}

@Preview
@Composable
fun SplashPreview() {
    ContactAppComposeTheme {
        SplashContent(SplashContract.UIState.InitState, {})
    }
}