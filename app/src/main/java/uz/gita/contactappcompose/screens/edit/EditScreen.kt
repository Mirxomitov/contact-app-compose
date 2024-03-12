package uz.gita.contactappcompose.screens.edit

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen

class EditScreen : Screen {
    @Composable
    override fun Content() {
        EditScreenContent()
    }
}

@Composable
fun EditScreenContent() {
    Text(text = "Edit SCREEN")
}

@Preview
@Composable
fun EditScreenPreview() {

}