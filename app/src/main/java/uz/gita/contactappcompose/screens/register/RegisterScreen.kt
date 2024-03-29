package uz.gita.contactappcompose.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectAsState
import uz.gita.contactappcompose.R
import uz.gita.contactappcompose.ui.components.ButtonComponent
import uz.gita.contactappcompose.ui.components.ClickableText
import uz.gita.contactappcompose.ui.components.HeightSpace

class RegisterScreen : Screen {
    @Composable
    override fun Content() {
        val viewModel: RegisterContract.ViewModel =
            getViewModel<RegisterViewModel>()
        RegisterScreeContent(
            viewModel.collectAsState().value, viewModel::eventDispatcher
        )
    }
}

@Composable
fun RegisterScreeContent(
    uiState: RegisterContract.UIState,
    eventDispatcher: (RegisterContract.Intent) -> Unit
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
            text = "Register",
            color = Color.Black,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "First name",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 24.dp, bottom = 4.dp)
        )
        var firstName by remember { mutableStateOf("") }
        OutlinedTextField(keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = firstName,
            onValueChange = { firstName = it })

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Last name",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 24.dp, bottom = 4.dp)
        )
        var lastName by remember { mutableStateOf("") }
        OutlinedTextField(keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = lastName,
            onValueChange = { lastName = it })

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Phone number",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 24.dp, bottom = 4.dp)
        )

        var phone by remember { mutableStateOf("") }
        OutlinedTextField(keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Next,
            keyboardType = KeyboardType.Phone
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = phone,
            onValueChange = { phone = it })

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Password",
            color = Color.Black,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 24.dp, bottom = 4.dp)
        )
        var password by remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }
        OutlinedTextField(keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
            imeAction = ImeAction.Done
        ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp),
            value = password,
            onValueChange = { password = it },
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(onClick = { showPassword = !showPassword },
                    content = {
                        Icon(modifier = Modifier
                            .clickable {
                                showPassword = !showPassword
                            }
                            .size(24.dp), painter = painterResource(
                            id = if (showPassword) R.drawable.eye
                            else R.drawable.hidden
                        ), contentDescription = "icon")
                    })
            })

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
                    RegisterContract.Intent.Register(
                        firstName.trim(),
                        lastName.trim(),
                        phone.trim(),
                        password.trim()
                    )
                )
            },
            enabled = enabled,
            isLoading = isLoading,
            modifier = Modifier.padding(horizontal = 24.dp, vertical = 8.dp)
        )

        ClickableText(
            fullText = "Do you have an account? Login",
            clickableText = "Login",
            onClick = { eventDispatcher(RegisterContract.Intent.Login) }
        )
        HeightSpace(height = 16)
    }
}


@Preview
@Composable
fun RegisterScreePreview() {

}