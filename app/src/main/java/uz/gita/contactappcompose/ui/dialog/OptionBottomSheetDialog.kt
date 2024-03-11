package uz.gita.contactappcompose.ui.dialog

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import uz.gita.contactappcompose.ui.theme.ContactAppComposeTheme

class OptionBottomSheetDialog : Screen {
    @Composable
    override fun Content() {

    }
}

@Composable
fun OptionBottomSheetDialogContent() {}

@Preview
@Composable
fun OptionBottomSheetDialogPreview() {
    ContactAppComposeTheme {
        OptionBottomSheetDialogContent()
    }
}