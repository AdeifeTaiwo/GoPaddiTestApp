package com.example.gopadditestapp.presentation.homescreen.components

import androidx.compose.material3.Button
import androidx.compose.material3.DatePickerDefaults
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DateRangePicker
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDateRangePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.gopadditestapp.component.GoPaddiBlueButton
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DateRangePickerDialog(
    onDismiss: () -> Unit,
    onDateSelected: (Long?, Long?) -> Unit
) {
    val dateRangePickerState = rememberDateRangePickerState(
        selectableDates = DatePickerDefaults.AllDates
    )

    DatePickerDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            GoPaddiBlueButton(
                buttonText = "Choose Date"
            ) {
                 onDateSelected(
                     dateRangePickerState.selectedStartDateMillis,
                     dateRangePickerState.selectedEndDateMillis
                 )
                 onDismiss()
             }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
        }
    ) {
        DateRangePicker(
            state = dateRangePickerState,
            title = {
                Text(
                    text = "Date",
                    style = MaterialTheme.typography.titleLarge
                )
            }
        )
    }
}

@Preview
@Composable
fun PreviewDateRangePickerDialog(){
    GoPaddiTestAppTheme {
        DateRangePickerDialog(
            onDismiss = {}
        ) { startDate, endDate ->  }
    }
}
