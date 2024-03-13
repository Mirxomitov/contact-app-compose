package uz.gita.contactappcompose.screens.add

import android.widget.Toast
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getViewModel
import org.orbitmvi.orbit.compose.collectSideEffect
import uz.gita.contactappcompose.ui.components.HeightSpace
import uz.gita.contactappcompose.utils.MaskTransformation
import uz.gita.contactappcompose.utils.logger

class AddScreen(private val doReload: () -> Unit) : Screen {
    @Composable
    override fun Content() {
        val context = LocalContext.current
        val viewModel = getViewModel<AddViewModel>()

        viewModel.collectSideEffect { sideEffect ->
            when (sideEffect) {
                is AddContract.SideEffect.Toast -> {
                    Toast.makeText(
                        context, sideEffect.message, Toast.LENGTH_SHORT
                    ).show()
                }

                AddContract.SideEffect.ReloadEffect -> doReload.invoke()
            }
        }

        AddScreenContent(viewModel::eventDispatcher)
    }
}

@Composable
fun AddScreenContent(
    eventDispatcher: (AddContract.Intent) -> Unit
) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .height(56.dp),
    ) {
        Text(text = "Отмена", modifier = Modifier
            .clickable {
                eventDispatcher(AddContract.Intent.Back)
            }
            .align(Alignment.CenterStart), fontSize = 16.sp)
        Text(
            text = "Создать контакт",
            modifier = Modifier.align(Alignment.Center),
            fontSize = 12.sp
        )

        logger(phone + " : PHONE NUMBER")
        TextButton(enabled = (firstName.length > 3) && (lastName.length > 3) && (phone.length == 9),
            modifier = Modifier.align(Alignment.CenterEnd),
            onClick = {
                eventDispatcher(
                    AddContract.Intent.AddContact(
                        firstName.trim(),
                        lastName.trim(),
                        "+998" + phone.trim(),
                    )
                )
            }) {
            Text(
                text = "Готово", fontSize = 16.sp
            )
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 56.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeightSpace(height = 12)
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text(text = "Имя") },
            value = firstName,
            onValueChange = {
                firstName = it
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words)
        )
        HeightSpace(height = 12)

        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp),
            label = { Text(text = "Фамилия") },
            value = lastName,
            onValueChange = {
                lastName = it
            },
            keyboardOptions = KeyboardOptions(capitalization = KeyboardCapitalization.Words),
        )

        HeightSpace(height = 18)

        val maxLength = 9
        OutlinedTextField(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
            value = phone,
            onValueChange = {
                if (it.length <= maxLength) {
                    phone = it.filter { it.isDigit() }
                }
            },
            prefix = {
                Text(text = "+998")
            },
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Sentences,
                keyboardType = KeyboardType.Phone,
                imeAction = ImeAction.Done
            ),
            visualTransformation = MaskTransformation(),
            singleLine = true,
            supportingText = {
                Text(
                    text = "${phone.length}/$maxLength",
                    color = if (phone.length == maxLength) Color.Green else Color.Black,
                )
            })
    }
}