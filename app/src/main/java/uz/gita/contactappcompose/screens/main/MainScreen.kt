package uz.gita.contactappcompose.screens.main

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import uz.gita.contactappcompose.data.model.ContactUIData
import uz.gita.contactappcompose.ui.items.ContactItem
import uz.gita.contactappcompose.ui.theme.BlackColor

class MainScreen : Screen {
    @Composable
    override fun Content() {
        MainScreenContent()
    }
}

@Composable
fun MainScreenContent() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
            ) {
                Text(text = "Контакты", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text(text = "Изменить", fontSize = 12.sp, fontWeight = FontWeight.Bold)

                Icon(
                    tint = BlackColor,
                    imageVector = Icons.Default.Add,
                    contentDescription = "add icon",
                    modifier = Modifier.size(24.dp)
                )
                Icon(
                    tint = BlackColor,
                    imageVector = Icons.Default.Settings,
                    contentDescription = "settings icon",
                    modifier = Modifier.size(24.dp)
                )
            }
        },
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(0) {
                ContactItem(ContactUIData("Tohir", "Mirxomitov", "+998903553620"))
            }
        }
    }
}


@Preview
@Composable
fun MainScreenPreview() {

}