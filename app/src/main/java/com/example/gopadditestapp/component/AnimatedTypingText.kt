package com.example.gopadditestapp.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.R
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.SatoshiTypography
import kotlinx.coroutines.delay


@Composable
fun AnimatedTypingText(
    text: String,
    color: Color = GoPaddiBlack100,
    style: TextStyle,
    typingSpeed: Long = 120L,     // speed per character (typing)
    deletingSpeed: Long = 100L,    // speed per character (deleting)
    pauseDuration: Long = 1000L,  // how long to wait before deleting
    onAnimationEnd: (() -> Unit)? = null // callback for navigation
) {
    var visibleText by remember { mutableStateOf("") }

    LaunchedEffect(text) {
        // Type forward
        visibleText = ""
        text.forEachIndexed { index, _ ->
            visibleText = text.take(index + 1)
            delay(typingSpeed)
        }

        // Pause
        delay(pauseDuration)

        // Done — call navigation callback
        onAnimationEnd?.invoke()
    }

    Text(
        fontFamily = FontFamily(Font(R.font.satoshi_regular)),
        style = SatoshiTypography.titleMedium.copy(
            color = color,
            fontSize = 16.sp
        ),
        text = visibleText,
        fontWeight = FontWeight.Normal
    )
}
