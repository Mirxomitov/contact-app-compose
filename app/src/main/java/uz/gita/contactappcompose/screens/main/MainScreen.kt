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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import uz.gita.contactappcompose.data.model.ContactUIData
import uz.gita.contactappcompose.ui.components.WidthSpace
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
            WidthSpace(width = 8)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Контакты",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(2f)
                )
                Text(
                    text = "Изменить",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.weight(1f)
                )

                Icon(
                    tint = BlackColor,
                    imageVector = Icons.Default.Add,
                    contentDescription = "add icon",
                    modifier = Modifier.size(24.dp)
                )
                WidthSpace(width = 8)

                Icon(
                    tint = BlackColor,
                    imageVector = Icons.Default.Settings,
                    contentDescription = "settings icon",
                    modifier = Modifier.size(24.dp)
                )
                WidthSpace(width = 8)
            }
        },
    ) { innerPadding ->
        LazyColumn(modifier = Modifier.padding(innerPadding)) {
            items(1) {
                ContactItem(
                    ContactUIData(
                        "Tohir",
                        "Mirxomitov",
                        "+998903553620"
                    )
                )
            }
        }
    }
}