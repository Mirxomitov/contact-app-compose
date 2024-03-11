package uz.gita.contactappcompose.screens.main

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import org.orbitmvi.orbit.compose.collectAsState
import org.orbitmvi.orbit.compose.collectSideEffect
import uz.gita.contactappcompose.ui.components.WidthSpace
import uz.gita.contactappcompose.ui.items.ContactItem
import uz.gita.contactappcompose.ui.theme.BlackColor

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: MainContract.ViewModel = getViewModel<MainViewModel>()
        val context = LocalContext.current
        val localBottomSheetNavigator = LocalBottomSheetNavigator.current

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                is MainContract.SideEffect.OpenBottomDialog -> {
                    //localBottomSheetNavigator.show()
                }
            }
        }


        MainScreenContent(
            viewModel.collectAsState().value,
            viewModel::onEventDispatchers
        )
    }
}

@Composable
fun MainScreenContent(
    uiState: MainContract.UIState,
    eventDispatcher: (MainContract.Intent) -> Unit
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            WidthSpace(width = 12)
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
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
                    modifier = Modifier.size(24.dp).clickable {
                        eventDispatcher(MainContract.Intent.AddContact)
                    }
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

        when (uiState) {
            is MainContract.UIState.EmptyState -> {
                EmptyState({})
            }

            is MainContract.UIState.Contacts -> {
                LazyColumn(modifier = Modifier.padding(innerPadding)) {
                    items(uiState.contacts) {
                        ContactItem(
                            contact = it,
                            onClick = {},
                            onLongClick = {}
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun EmptyState(addContact: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
    ) {
        Column(modifier = Modifier.align(Alignment.Center)) {

            Text(
                modifier = Modifier.align(Alignment.CenterHorizontally),
                text = "Empty",
                fontSize = 24.sp
            )

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                modifier = Modifier
                    .height(56.dp)
                    .width(200.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                onClick = addContact,
                content = {
                    Text(
                        text = "Add",
                        color = Color.White
                    )
                }
            )
        }
    }
}
