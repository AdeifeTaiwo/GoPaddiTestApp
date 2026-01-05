package com.example.gopadditestapp.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.ui.theme.GoPaddiBlue600
import com.example.gopadditestapp.ui.theme.GoPaddiDisabledBlack
import com.example.gopadditestapp.ui.theme.satoshiFontFamily
import kotlinx.coroutines.flow.collectLatest


@Composable
fun GoPaddiBlueButton(
    modifier: Modifier = Modifier,
    buttonText: String = "Continue",
    enabled: Boolean = false,
    onContinueButtonClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    var isPressed by remember { mutableStateOf(false) }

    // Color animation based on `isPressed` state
    val buttonColor by animateColorAsState(
        targetValue = if (isPressed) GoPaddiBlue600.copy(alpha = 0.3f) else GoPaddiBlue600,
        label = "ButtonColorAnimation"
    )

    // Observe interactions and update `isPressed`
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collectLatest { interaction: Interaction ->
            when (interaction) {
                is PressInteraction.Press -> isPressed = true
                is PressInteraction.Release, is PressInteraction.Cancel -> isPressed = false
            }
        }
    }

    OutlinedButton(
        modifier = modifier
            .height(62.dp)
            .padding(horizontal = 0.dp)
            .fillMaxWidth(),
        onClick = {
            onContinueButtonClick()
        },
        enabled = enabled,
        shape = RoundedCornerShape(2.dp),
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) buttonColor else Color.White.copy(1f),
            disabledContainerColor = GoPaddiDisabledBlack
        ),
        border = BorderStroke(1.dp, color = Color.Transparent)
    ) {
        Text(
            text = buttonText,
            style = TextStyle(color = Color.White, fontSize = 16.sp, fontFamily = satoshiFontFamily)
        )
    }
}




@Composable
fun GoPaddiOutlinedButton(
    modifier: Modifier = Modifier,
    buttonText: String = "Continue",
    enabled: Boolean = false,
    onContinueButtonClick: () -> Unit
) {

    val interactionSource = remember { MutableInteractionSource() }
    var isPressed by remember { mutableStateOf(false) }

    // Color animation based on `isPressed` state
    val buttonColor by animateColorAsState(
        targetValue = if (isPressed) GoPaddiDisabledBlack else GoPaddiBlue600,
        label = "ButtonColorAnimation"
    )

    // Observe interactions and update `isPressed`
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collectLatest { interaction: Interaction ->
            when (interaction) {
                is PressInteraction.Press -> isPressed = true
                is PressInteraction.Release, is PressInteraction.Cancel -> isPressed = false
            }
        }
    }

    OutlinedButton(
        modifier = modifier
            .height(62.dp)
            .padding(horizontal = 0.dp)
            .fillMaxWidth(),
        onClick = {
            onContinueButtonClick()
        },
        enabled = enabled,
        shape = RoundedCornerShape(4.dp),
        interactionSource = interactionSource,
        colors = ButtonDefaults.buttonColors(
            containerColor = if (enabled) buttonColor else GoPaddiDisabledBlack.copy(0.2f),
            disabledContainerColor = GoPaddiDisabledBlack
        ),
        border = BorderStroke(1.dp, color = Color.Transparent)
    ) {
        Text(
            text = buttonText,
            style = TextStyle(color = Color.White, fontSize = 16.sp, fontFamily = satoshiFontFamily)
        )
    }
}