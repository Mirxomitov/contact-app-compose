package uz.gita.contactappcompose.screens.verify

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import uz.gita.contactappcompose.R
import uz.gita.contactappcompose.ui.components.ButtonComponent
import uz.gita.contactappcompose.ui.components.HeightSpace
import uz.gita.contactappcompose.ui.theme.ContactAppComposeTheme

class VerifyScreen(private val phone: String) : Screen {
    @Composable
    override fun Content() {
        val viewModel = getViewModel<VerifyViewModel>()
        VerifyContent(
            phone,
            viewModel::eventDispatcher
        )
    }
}

@Composable
fun VerifyContent(
    phone: String,
    eventDispatcher: (VerifyContract.Intent) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeightSpace(height = 16)
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(20f),
            painter = painterResource(id = R.drawable.img),
            contentDescription = "",
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "SMS code",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 24.dp, bottom = 4.dp)
        )
        var smsCode by remember { mutableStateOf("") }

        OutlinedTextField(
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = smsCode,
            onValueChange = { smsCode = it },
        )

        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .weight(20f)
        )

        var enabled by remember { mutableStateOf(true) }
        var isLoading by remember { mutableStateOf(false) }

        ButtonComponent(
            text = "Register",
            onClicked = {
                enabled = false
                isLoading = true
                eventDispatcher(
                    VerifyContract.Intent.CheckCode(
                        smsCode,
                        phone = phone
                    )
                )
            },
            enabled = enabled,
            isLoading = isLoading,
            modifier = Modifier.padding(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun VerifyPreview() {
    ContactAppComposeTheme {
        VerifyContent("VerifyContract.UIState.InitState", {})
    }
}
