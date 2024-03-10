package uz.gita.contactappcompose.ui.components

//import androidx.compose.material.MaterialTheme
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import uz.gita.contactappcompose.utils.logger

@Composable
fun ClickableText(
    fullText: String,
    clickableText: String,
    onClick: () -> Unit
) {

    val annotatedString = buildAnnotatedString {
        append(fullText)
        addStyle(
            style = SpanStyle(
                color = Color.Blue,
            ),
            start = fullText.indexOf(clickableText),
            end = fullText.indexOf(clickableText) + clickableText.length
        )
        addStringAnnotation(
            tag = "Clickable",
            annotation = clickableText,
            start = fullText.indexOf(clickableText),
            end = fullText.indexOf(clickableText) + clickableText.length
        )
    }

    ClickableText(
        text = annotatedString,
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                "Clickable",
                start = offset,
                end = offset
            ).firstOrNull()?.let { annotation ->
                    if (annotation.item == clickableText) {
                        onClick()
                        logger("CLICKED")
                    }
                }
        }
    )
}

@Preview
@Composable
fun PreviewClickableTextExample() {
    ClickableText(
        "Do you have an account? Login",
        clickableText = "Login",
        {}
    )
}