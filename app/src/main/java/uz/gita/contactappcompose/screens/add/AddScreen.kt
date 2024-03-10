package uz.gita.contactappcompose.screens.add

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen

class AddScreen : Screen {
    @Composable
    override fun Content() {
AddScreenContent()
    }
}

@Composable
fun AddScreenContent() {
    Text(text = "ADD SCREEN")
}

@Preview
@Composable
fun AddScreenPreview() {

}