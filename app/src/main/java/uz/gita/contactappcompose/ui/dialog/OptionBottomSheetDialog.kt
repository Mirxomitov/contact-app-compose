package uz.gita.contactappcompose.ui.dialog

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.bottomSheet.LocalBottomSheetNavigator
import uz.gita.contactappcompose.R
import uz.gita.contactappcompose.ui.components.HeightSpace
import uz.gita.contactappcompose.ui.theme.ContactAppComposeTheme

class OptionBottomSheetDialog(
    private val title: String,
    private val onCall: () -> Unit,
    private val onEdit: () -> Unit,
    private val onDelete: () -> Unit,
) : Screen {
    @Composable
    override fun Content() {
        val bottomSheetNavigator = LocalBottomSheetNavigator.current

        OptionBottomSheetDialogContent(
            title = title,
            onCall = onCall,
            onEdit = onEdit,
            onDelete = onDelete,
            onHide = {
                bottomSheetNavigator.hide()
            },
        )
    }
}

@Composable
fun OptionBottomSheetDialogContent(
    title: String,
    onCall: () -> Unit,
    onEdit: () -> Unit,
    onDelete: () -> Unit,
    onHide: () -> Unit
) {
    Column (horizontalAlignment = Alignment.CenterHorizontally) {
        Text(text = title, fontSize = 18.sp, fontWeight = FontWeight.Bold)
        HeightSpace(height = 4)
        Row(modifier = Modifier.fillMaxWidth()) {
            Item(
                modifier = Modifier
                    .weight(1f)
                    .height(72.dp),
                onClick = onDelete,
                res = R.drawable.baseline_delete_outline_24,
                iconText = "Удалить"
            )

            Item(
                modifier = Modifier
                    .weight(1f)
                    .height(72.dp),
                onClick = onEdit,
                res = R.drawable.baseline_mode_edit_24,
                iconText = "Изменить"
            )

            Item(
                modifier = Modifier
                    .weight(1f)
                    .height(72.dp),
                onClick = onCall,
                res = R.drawable.call,
                iconText = "Вызов"
            )
        }
    }
}

@Composable
private fun Item(
    modifier: Modifier,
    onClick: () -> Unit,
    @DrawableRes res: Int,
    iconText: String,
) {
    Column(
        modifier = modifier,
    ) {
        IconButton(onClick = onClick) {
            Icon(
                painter = painterResource(id = res),
                contentDescription = "delete icon"
            )
        }

        Text(text = iconText, fontSize = 12.sp, fontWeight = FontWeight.Light)
    }
}

@Preview
@Composable
fun OptionBottomSheetDialogPreview() {
    ContactAppComposeTheme {
        OptionBottomSheetDialogContent(
            title = "User name",
            onCall = {},
            onEdit = {},
            onDelete = {},
            onHide = {},
        )
    }
}

//            Column(
//                modifier = Modifier
//                    .weight(1f)
//                    .height(72.dp)
//            ) {
//                IconButton(onClick = onDelete) {
//                    Icon(
//                        painter = painterResource(id = R.drawable.baseline_delete_outline_24),
//                        contentDescription = "delete icon"
//                    )
//                }
//
//                Text(text = "Удалить", fontSize = 12.sp, fontWeight = FontWeight.Light)
//            }