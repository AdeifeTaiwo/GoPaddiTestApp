package com.example.gopadditestapp.component


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.DialogProperties
import com.example.gopadditestapp.R
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.satoshiFontFamily

//


@Composable
fun GopaddiSuccessDialog(
    buttonText: String = "Continue",
    successMessage: String = "Trip Created Successfully",
    onContinue: (() -> Unit)? = null,
    onDismiss: () -> Unit,
) {
    AlertDialog(
        modifier = Modifier.padding(horizontal = 10.dp),
        containerColor = Color.White,
        shape = RoundedCornerShape(8.dp),
        onDismissRequest = { onDismiss() }, // Close dialog when dismissed
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                GoPaddiBlueButton(
                    buttonText = buttonText,
                    modifier = Modifier.fillMaxWidth(0.9f),
                    enabled = true
                ) {
                    onContinue?.invoke()
                }
                //Spacer(modifier = Modifier.height(24.dp))
            }
        },
        dismissButton = {
        },
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(alpha = 0f),
                    horizontalArrangement = Arrangement.End
                ) {
                }
                Image(
                    painter = painterResource(
                        R.drawable.ic_success_checkmark
                    ),
                    contentDescription = "Success",
                    modifier = Modifier
                        .clip(CircleShape) // Clips the image to a circular shape
                        .size(90.dp),      // Sets the size of the image
                    contentScale = ContentScale.Inside // Adjusts the scaling of the image within the bounds
                )
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Awesome",
                    color = GoPaddiBlack100,
                    fontFamily = satoshiFontFamily,
                    fontWeight = FontWeight.W500,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        text = {
            Text(
                successMessage,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = GoPaddiBlack100,
                fontFamily = satoshiFontFamily,
                fontWeight = FontWeight.W400,
                overflow = TextOverflow.Ellipsis
            )
        },
        properties = DialogProperties(dismissOnClickOutside = false) // Optional properties
    )
}

@Preview(
    showBackground = true,
    widthDp = 400
)
@Composable
fun PreviewGoPaddiSuccessDialog() {
    GopaddiSuccessDialog {

    }
}




@Composable
fun GoPaddiErrorDialog(
    errorMessage: String? = null,
    buttonText: String = "Close",
    onContinue: (() -> Unit)? = null,
    onDismiss: (() -> Unit)? = null,
) {
    AlertDialog(
        modifier = Modifier.padding(horizontal = 10.dp),
        containerColor = Color.White,
        shape = RoundedCornerShape(8.dp),
        onDismissRequest = { onDismiss?.invoke() }, // Close dialog when dismissed
        confirmButton = {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                GoPaddiBlueButton (
                    buttonText = buttonText,
                    modifier = Modifier.fillMaxWidth(.9f),
                    enabled = true
                ) {
                    onContinue?.invoke()
                }
                //Spacer(modifier = Modifier.height(24.dp))
            }
        },
        dismissButton = {
        },
        title = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .alpha(alpha = 0f),
                    horizontalArrangement = Arrangement.End
                ) {
                }
                Image(
                    painter = painterResource(
                        R.drawable.ic_error_compose
                    ),
                    contentDescription = "Error Icon",
                    modifier = Modifier
                        .clip(CircleShape) // Clips the image to a circular shape
                        .size(70.dp),      // Sets the size of the image
                    contentScale = ContentScale.Inside // Adjusts the scaling of the image within the bounds
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    text = "Error!",
                    color = GoPaddiBlack100,
                    fontFamily = satoshiFontFamily,
                    fontWeight = FontWeight.W500,
                    textAlign = TextAlign.Center,
                    overflow = TextOverflow.Ellipsis
                )
            }
        },
        text = {
            Text(
                text = errorMessage?:"We Encountered an error, Please try again",
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                color = GoPaddiBlack100,
                fontFamily = satoshiFontFamily,
                fontWeight = FontWeight.W400,
                overflow = TextOverflow.Ellipsis
            )
        },
        properties = DialogProperties(dismissOnClickOutside = false) // Optional properties
    )
}



@Preview(
    showBackground = true,

)
@Composable
fun PreviewGoPaddiErrorDialog() {
    GoPaddiErrorDialog {

    }
}
