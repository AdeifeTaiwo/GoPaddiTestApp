import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.R
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.GoPaddiBlack15
import com.example.gopadditestapp.ui.theme.GoPaddiBlue600
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import com.example.gopadditestapp.ui.theme.SatoshiTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GoPaddiTextField(
    modifier: Modifier = Modifier,
    text: String,
    headerText: String = "Please Select A City",
    hintText: String = "Enter City",
    hasError: Boolean? = false,
    errorMessage: String = "",
    headerFontWeight: FontWeight = FontWeight.Normal,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    onChange: (String) -> Unit,
) {
    val interactionSource = remember { MutableInteractionSource() }
    val focusRequester = remember { FocusRequester() }
    val isFocused = remember { mutableStateOf(false) }


    Column {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Text(
                fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                style = SatoshiTypography.titleMedium.copy(
                    color = GoPaddiBlack100,
                    fontSize = 16.sp
                ),
                text = headerText,
                fontWeight = headerFontWeight
            )
        }
        Spacer(modifier = Modifier.height(6.dp))

        BasicTextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(
                    1.dp,
                    if (isFocused.value) GoPaddiBlue600 else GoPaddiBlack15,
                    shape = RoundedCornerShape(4.dp)
                )
                .clip(RoundedCornerShape(2.dp))
                .focusRequester(focusRequester) // Attach focus requester
                .onFocusChanged { focusState -> // Capture focus state changes
                    isFocused.value = focusState.isFocused
                },
            value = text,
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Ascii
            ),
            visualTransformation = visualTransformation,
            onValueChange = {
                onChange(it)
            },
            textStyle = TextStyle(
                fontSize = 18.sp
            ),
        ) { innerTextField ->
            OutlinedTextFieldDefaults.DecorationBox(
                value = text,
                innerTextField = innerTextField,
                enabled = true,
                singleLine = true,
                isError = hasError ?: false,
                interactionSource = interactionSource,
                visualTransformation = visualTransformation,
                placeholder = {
                    Text(
                        text = hintText,
                        maxLines = 1, // Limits the text to one line
                        overflow = TextOverflow.Ellipsis
                    )
                },

                container = {
                    OutlinedTextFieldDefaults.ContainerBox(
                        enabled = true,
                        isError = hasError ?: false,

                        interactionSource = interactionSource,
                        colors = OutlinedTextFieldDefaults.colors(
                            focusedBorderColor = GoPaddiBlue600,
                            focusedContainerColor = GoPaddiBlue600,
                            unfocusedBorderColor = GoPaddiBlack15,
                            cursorColor = GoPaddiBlack15,

                            ),
                        shape = RoundedCornerShape(4.dp),
                        focusedBorderThickness = OutlinedTextFieldDefaults.UnfocusedBorderThickness,
                        unfocusedBorderThickness = OutlinedTextFieldDefaults.UnfocusedBorderThickness,
                    )
                }
            )

        }
//        if(hasError == false) {
//            Spacer(modifier = Modifier.height(3.dp))
//            Text(
//                modifier = Modifier
//                    .fillMaxWidth(),
//                text = errorMessage,
//                color = monieswitchBlack,
//                fontFamily = onestFontFamily,
//                fontWeight = FontWeight.W500,
//                textAlign = TextAlign.Start,
//                overflow = TextOverflow.Ellipsis
//            )
//        }

    }
}
@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Composable
fun CustomRoundCornerTextFieldPreview() {
    PreviewWrapper {
       GoPaddiTextField(
           text = ""
       ){}
    }
}
@Composable
fun TripDescriptionField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {

        // Label
        Text(
            text = "Trip Description",
            style = MaterialTheme.typography.titleMedium,
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = value,
            onValueChange = onValueChange,
            placeholder = {
                Text(
                    text = "Tell us more about the trip",
                    color = Color(0xFF9AA0A6)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(min = 180.dp),
            shape = RoundedCornerShape(12.dp),
            textStyle = TextStyle(
                fontSize = 16.sp,
                lineHeight = 22.sp
            ),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = GoPaddiBlue600,   // purple focus
                unfocusedBorderColor = GoPaddiBlack100.copy(0.3f),
                cursorColor = GoPaddiBlue600
            ),
            maxLines = 6
        )
    }
}

@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Composable
fun PreviewtomRoundCornerTextField() {
    PreviewWrapper {
        TripDescriptionField(
            value = "hello",
            onValueChange = {

            },
            modifier = Modifier
        )
    }
}

@Composable
fun PreviewWrapper(content: @Composable () -> Unit = {}) {
    GoPaddiTestAppTheme () {
        content()
    }
}

