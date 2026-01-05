package com.example.gopadditestapp.presentation

import GoPaddiTextField
import TripDescriptionField
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.MenuDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gopadditestapp.R
import com.example.gopadditestapp.component.GoPaddiBlueButton
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.GoPaddiBlue600
import com.example.gopadditestapp.ui.theme.SatoshiTypography

@Composable
fun CreateTripBottomDialog(
    onDismiss: () -> Unit,
    onClickNext: (String, String, String) -> Unit
) {

    var tripNameText by remember { mutableStateOf("") }
    var selectedTravelStyle by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(horizontal = 16.dp, vertical = 24.dp)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Image(painter = painterResource(R.drawable.ic_palm_tree), contentDescription = "")
                Image(
                    modifier = Modifier.clickable(
                        onClick = onDismiss
                    ),
                    painter = painterResource(R.drawable.ic_cancel), contentDescription = "")
            }
            Spacer(modifier = Modifier.height(10.dp))
            HeaderTextWithSubHeaderText(
                headerText = "Create A Trip",
                subHeaderText = "Let's Go! Build Your Next Adventure"
            )

            Spacer(modifier = Modifier.height(30.dp))

            GoPaddiTextField(
                headerText = "Trip Name",
                hintText = "Enter the trip name",
                text = tripNameText,
                headerFontWeight = FontWeight.Bold
            ) {
                tripNameText = it
            }

            Spacer(modifier = Modifier.height(16.dp))
            SimpleDropdown(
                options = listOf("Solo", "Family", "Friends", "Business"),
                label = "Travel Style",
                onSelected = {
                    selectedTravelStyle = it
                }
            )

            Spacer(modifier = Modifier.height(16.dp))
            TripDescriptionField(
                description,
                onValueChange = {
                    description = it
                },
                modifier = Modifier,
            )
            Spacer(modifier = Modifier.height(8.dp))
            GoPaddiBlueButton(
                modifier = Modifier,
                enabled = tripNameText.isNotEmpty() && selectedTravelStyle.isNotEmpty() && description.isNotEmpty(),
                buttonText = "Next"
            ) {
                onClickNext(
                    tripNameText, selectedTravelStyle,description
                )

            }
        }
    }
}


@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO,
    showSystemUi = true
)
@Composable
fun PreviewCreateTripBottomDialog() {
    CreateTripBottomDialog(
        onDismiss = {},
        onClickNext = {tripName, travelStyle, tripDesc ->}
    )
}

@Composable
fun HeaderTextWithSubHeaderText(
    headerText: String,
    subHeaderText: String
) {
    Column {
        Text(
            fontFamily = FontFamily(Font(R.font.satoshi_bold)),
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 20.sp
            ),
            text = headerText,
            fontWeight = FontWeight.W700
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(
            fontFamily = FontFamily(Font(R.font.satoshi_regular)),
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 16.sp
            ),
            text = subHeaderText,
            fontWeight = FontWeight.Normal
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SimpleDropdown(
    options: List<String>,
    label: String,
    onSelected: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selected by remember { mutableStateOf("") }

    Column {
        Text(
            fontFamily = FontFamily(Font(R.font.satoshi_regular)),
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 16.sp
            ),
            text = "Travel Style",
            fontWeight = FontWeight.Bold
        )
        ExposedDropdownMenuBox(
            expanded = expanded,
            onExpandedChange = { expanded = !expanded }
        ) {
            OutlinedTextField(
                value = selected,
                onValueChange = {},
                readOnly = true,
                label = { Text(label) },
                trailingIcon = {
                    Image(
                        painter = painterResource(R.drawable.ic_caretdown),
                        contentDescription = "Caret down"
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedBorderColor = GoPaddiBlue600,   // purple focus
                    unfocusedBorderColor = GoPaddiBlack100.copy(0.3f),
                    cursorColor = Color(0xFF7B61FF)
                ),
                modifier = Modifier
                    .menuAnchor()
                    .fillMaxWidth()
            )

            ExposedDropdownMenu(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.White),
                expanded = expanded,
                onDismissRequest = { expanded = false }
            ) {
                options.forEach { option ->
                    DropdownMenuItem(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(Color.White),
                        text = { Text(option) },
                        colors = MenuDefaults.itemColors(
                        ),
                        onClick = {
                            selected = option
                            expanded = false
                            onSelected(option)
                        }
                    )
                }
            }
        }
    }
}
