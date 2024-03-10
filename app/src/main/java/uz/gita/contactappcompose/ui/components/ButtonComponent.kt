package uz.gita.contactappcompose.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import uz.gita.contactappcompose.ui.theme.ColorContactItemText
import uz.gita.contactappcompose.ui.theme.ContactAppComposeTheme
import uz.gita.contactappcompose.ui.theme.CustomRippleTheme

@Composable
fun ButtonComponent(
    text: String,
    onClicked: (() -> Unit),
    modifier: Modifier,
    isLoading: Boolean = false,
    enabled: Boolean = true,
    enabledColor: Color = Color.Blue,
    disabledColor: Color = Color.Blue.copy(alpha = 0.5f)
) {

        Button(
            onClick = onClicked,
            enabled = enabled,
            colors = ButtonDefaults.buttonColors(
                containerColor = enabledColor,
                disabledContainerColor = disabledColor
            ),
            content = {
                if (isLoading) {
                    CircularProgressIndicator(
                        color = Color.White,
                        modifier = Modifier
                            .padding(12.dp)
                            .size(24.dp),
                        strokeWidth = 2.dp
                    )
                } else {
                    Row {
                        Text(text)
                    }
                }
            },
            modifier = modifier
                .fillMaxWidth()
                .height(56.dp),
            shape = RoundedCornerShape(12.dp)
        )

}

@Preview(showBackground = true)
@Composable
private fun ButtonComponentPreview() {
    ContactAppComposeTheme {
        ButtonComponent(
            text = "Sample",
            onClicked = { },
            isLoading = false,
            enabled = true,
            modifier = Modifier.padding(vertical = 16.dp)
        )
    }
}

