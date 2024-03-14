package uz.gita.contactappcompose.utils

import android.util.Log
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.input.OffsetMapping
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.text.input.VisualTransformation

fun logger(msg: String, tag: String = "TTT") {
    Log.d(tag, msg)
}

class MaskTransformation() : VisualTransformation {
    override fun filter(text: AnnotatedString): TransformedText {
        return maskFilter(text)
    }
}

fun maskFilter(text: AnnotatedString): TransformedText {
    val trimmed =
        if (text.text.length >= 9) text.text.substring(0..8) else text.text
    val out = StringBuilder()

    for (i in trimmed.indices) {
        if (i == 1) {
            out.append(trimmed[i])
            out.append(") ")
        } else {
            when (i) {
                0 -> {
                    out.append("(")
                }

                5 -> {
                    out.append("-")
                }

                7 -> {
                    out.append("-")
                }
            }
            out.append(trimmed[i])
        }
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            logger("offset1=$offset")
            return when (offset) {
                0 -> 0
                1 -> 3
                2 -> 4
                3 -> 6
                4 -> 7
                5 -> 8
                6 -> 10
                7 -> 11
                8 -> 13
                else -> 14
            }
        }
        override fun transformedToOriginal(offset: Int): Int {
            logger("offset2=$offset")
            return when (offset) {
                0 -> 0
                1 -> 1
                2 -> 1
                3 -> 2
                4 -> 2
                5 -> 3
                6 -> 4
                7 -> 5
                8 -> 5
                9 -> 6
                10 -> 7
                11 -> 7
                12 -> 8
                13 -> 8
                else -> 9
            }
        }
    }

    return TransformedText(
        AnnotatedString(out.toString()),
        numberOffsetTranslator
    )
}
/*
 // NNNNN-NNN
    val trimmed = if (text.text.length >= 8) text.text.substring(0..7) else text.text
    var out = ""
    for (i in trimmed.indices) {
        out += trimmed[i]
        if (i==4) out += "-"
    }

    val numberOffsetTranslator = object : OffsetMapping {
        override fun originalToTransformed(offset: Int): Int {
            if (offset <= 4) return offset
            if (offset <= 8) return offset +1
            return 9

        }

        override fun transformedToOriginal(offset: Int): Int {
            if (offset <=5) return offset
            if (offset <=9) return offset -1
            return 8
        }
    }
 */