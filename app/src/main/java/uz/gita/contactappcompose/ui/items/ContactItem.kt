package uz.gita.contactappcompose.ui.items

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import uz.gita.contactappcompose.data.model.ContactUIData
import uz.gita.contactappcompose.ui.components.WidthSpace
import uz.gita.contactappcompose.ui.theme.ColorContactItemCircle
import uz.gita.contactappcompose.ui.theme.ColorContactItemText

@Composable
fun ContactItem(contact: ContactUIData) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .padding(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(64.dp)
                .background(
                    shape = CircleShape,
                    color = ColorContactItemCircle,
                ),
            contentAlignment = Alignment.Center,
            content = {
                if (contact.firstName.trim() != "") {
                    Text(
                        text = contact.firstName[0].uppercase(),
                        color = ColorContactItemText,
                        fontSize = 12.sp
                    )
                }
            }
        )
        WidthSpace(width = 12)
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = contact.firstName + " " + contact.lastName,
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            Text(
                text = contact.phoneNumber,
                fontSize = 8.sp,
                fontWeight = FontWeight(200),
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
        }
    }
}
