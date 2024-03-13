package uz.gita.contactappcompose.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.contactappcompose.ui.theme.ContactAppComposeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddContactTextField(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    labelColor: Color,
    keyboardOptions: KeyboardOptions,
) {

    Box  {
        TextField(
            modifier = Modifier.padding(4.dp),
            value = value,
            onValueChange = {
                onValueChange(it)
            },
            colors = TextFieldDefaults.textFieldColors(
                focusedTextColor = Color.Black,
                containerColor = Color(0xFFEEEEEE),
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            keyboardOptions = keyboardOptions
        )

        if (value.isEmpty())
            Text(
                text = label,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                color = labelColor,
                modifier = Modifier.align(Alignment.CenterStart).padding(18.dp)
            )
    }
}
