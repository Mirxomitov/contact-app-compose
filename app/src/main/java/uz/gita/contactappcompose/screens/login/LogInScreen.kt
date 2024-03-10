package uz.gita.contactappcompose.screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import uz.gita.contactappcompose.R

class LogInScreen : Screen {
    @Composable
    override fun Content() {
        LogInScreeContent()
    }
}

@Composable
fun LogInScreeContent() {
    Column(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f),
            painter = painterResource(id = R.drawable.img),
            contentDescription = "",
        )

        Text(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            text = "Login",
            color = Color.Black,
            fontSize = 24.sp,
        )

        var firstName by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier,
            value = firstName,
            onValueChange = { firstName = it })
        Spacer(modifier = Modifier.height(16.dp))
        var lastName by remember { mutableStateOf("") }
        OutlinedTextField(
            modifier = Modifier,
            value = lastName,
            onValueChange = { lastName = it })
        Spacer(modifier = Modifier.height(16.dp))
        var password by remember { mutableStateOf("") }
        var showPassword by remember { mutableStateOf(false) }

        OutlinedTextField(
            modifier = Modifier,
            value = password,
            onValueChange = { password = it },
            visualTransformation = if (showPassword) {
                VisualTransformation.None
            } else {
                PasswordVisualTransformation()
            },
            trailingIcon = {
                IconButton(
                    onClick = { showPassword = !showPassword },
                    content = {
                        Icon(
                            modifier = Modifier.clickable {
                                showPassword = !showPassword
                            },
                            painter = painterResource(
                                id = if (showPassword) R.drawable.eye
                                else R.drawable.hidden
                            ),
                            contentDescription = "icon"
                        )
                    }
                )
            }
        )
        
        Button(onClick = {}) {
            
        }
    }
}


@Preview
@Composable
fun LogInScreePreview() {

}