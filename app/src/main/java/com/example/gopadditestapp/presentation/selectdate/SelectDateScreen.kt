package com.example.gopadditestapp.presentation.selectdate

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalBottomSheetDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gopadditestapp.R
import com.example.gopadditestapp.component.GoPaddiAppBarBlack
import com.example.gopadditestapp.component.GoPaddiBlueButton
import com.example.gopadditestapp.component.GoPaddiCustomLoader
import com.example.gopadditestapp.component.GoPaddiErrorDialog
import com.example.gopadditestapp.component.GopaddiSuccessDialog
import com.example.gopadditestapp.data.model.TripInformation
import com.example.gopadditestapp.navigation.GetNavigationBundle.getCityInformation
import com.example.gopadditestapp.navigation.Screens
import com.example.gopadditestapp.presentation.CreateTripBottomDialog
import com.example.gopadditestapp.presentation.selectdate.component.SelectedDateContainer
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.GoPaddiBlack15
import com.example.gopadditestapp.ui.theme.GoPaddiBlue600
import com.example.gopadditestapp.ui.theme.GoPaddiNeutral200
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import com.example.gopadditestapp.ui.theme.SatoshiTypography
import com.example.gopadditestapp.utils.DateUtilsKt
import com.example.gopadditestapp.utils.getScreenHeight
import io.github.boguszpawlowski.composecalendar.SelectableCalendar
import io.github.boguszpawlowski.composecalendar.rememberSelectableCalendarState
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.math.absoluteValue

@OptIn(ExperimentalMaterial3Api::class)
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun SelectDateScreen(
    navController: NavController
) {
    val height = getScreenHeight() * 0.6
    var startDate by remember { mutableStateOf("") }
    var endDate by remember { mutableStateOf("") }

    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { newValue ->
            newValue != SheetValue.Hidden
        }
    )

    val viewModel : CreateTripViewModel =  hiltViewModel()
    val uiState = viewModel.uiState.collectAsState().value
    val cityDetail = navController.getCityInformation()

    //show unpin hub bottom dialog
    var showSuccessDialog by remember { mutableStateOf(false) }
    var showErrorDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            Column {
                GoPaddiAppBarBlack(icon = R.drawable.ic_cancel, titleText = "Date") {
                    navController.popBackStack()
                }
                HorizontalDivider(thickness = 0.5.dp)
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxHeight()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .height(height.dp)
                    .verticalScroll(rememberScrollState())

            ) {
                Spacer(modifier = Modifier.padding(top = 8.dp))
                CustomCalendar() {
                    startDate = it
                }


                Spacer(modifier = Modifier.padding(top = 8.dp))
                CustomCalendar() {
                    endDate = it
                }
                Spacer(modifier = Modifier.padding(top = 8.dp))
            }

            Box(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .background(Color.White)
            ) {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Row {
                        SelectedDateContainer(
                            modifier = Modifier.weight(0.5f),
                            headerText = "Start Date",
                            selectedDate = startDate
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        SelectedDateContainer(
                            modifier = Modifier.weight(0.5f),
                            headerText = "End Date",
                            selectedDate = endDate
                        )

                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    GoPaddiBlueButton(
                        modifier = Modifier,
                        enabled = startDate.isNotEmpty() && endDate.isNotEmpty(),
                        buttonText = "Choose Date"
                    ) {
                        showBottomSheet = true
                    }

                }
            }


            if (showBottomSheet) {
                ModalBottomSheet(
                    modifier = Modifier
                        .fillMaxHeight(0.97f)
                        .align(Alignment.TopStart),
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = sheetState,
                    containerColor = Color.White,
                    scrimColor = Color.Gray.copy(alpha = 0.2f),
                    properties = ModalBottomSheetDefaults.properties(
                        shouldDismissOnBackPress = false
                    )
                ) {
                    CreateTripBottomDialog(
                        onDismiss = {
                            showBottomSheet = false
                        },
                        onClickNext = { tripName, travelStyle, tripDesc ->
                            val tripInfo = TripInformation(
                                startDate = startDate,
                                endDate = endDate,
                                tripName = tripName,
                                tripDescription = tripDesc,
                                travelStyle = travelStyle,
                                tripDate = startDate,
                                tripDuration = DateUtilsKt.daysBetween(start =startDate, end = endDate).absoluteValue.toString() + if (DateUtilsKt.daysBetween(start =startDate, end = endDate) ==1L) "Day" else "Days",
                                longitude = 6.33332,
                                latitude = 3.3333,
                                city = cityDetail?.city?:"",
                                country = cityDetail?.country?:"",
                                airport = cityDetail?.airport?:"",
                                countryCode = cityDetail?.countryCode?:"",
                                flag = cityDetail?.flag?:""
                            )
                            showBottomSheet = false
                            viewModel.createTrip(tripInfo)
                        }
                    )
                }
            }

            if (uiState.isLoading) {
                GoPaddiCustomLoader {
                }
            }

            if(uiState.myTrips!= null){
                showSuccessDialog = true
            }

            if(showSuccessDialog) {
                GopaddiSuccessDialog(
                    onContinue = {
                        viewModel.dismissSuccessDialog()
                        showSuccessDialog = false
                        navController.navigate(Screens.GoPaddiHomeScreen.name)
                    }
                ) {
                    viewModel.dismissSuccessDialog()
                    showSuccessDialog = false
                    navController.navigate(Screens.GoPaddiHomeScreen.name)
                }
            }


            if(uiState.hasError) {
                GoPaddiErrorDialog(
                    onContinue = {
                        viewModel.dismissErrorDialog()
                    }
                ) {
                    viewModel.dismissErrorDialog()
                }

            }

        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CustomCalendar(
    onDateSelected: (String) -> Unit
) {
    val state = rememberSelectableCalendarState()
    var selectedDate by remember { mutableStateOf<LocalDate?>(null) }
    val dateFormatter = DateTimeFormatter.ofPattern("d MMM, yyyy", Locale.ENGLISH)

    SelectableCalendar(
        calendarState = state,
        dayContent = { dayState ->

            val isSelected = selectedDate == dayState.date

            Card(
                modifier = Modifier
                    .size(44.dp)
                    .padding(top = 4.dp)
                    .clickable(
                        enabled = dayState.isFromCurrentMonth
                    ) {
                        selectedDate = dayState.date
                        onDateSelected(dayState.date.format(dateFormatter))
                    },
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(
                    containerColor = if (dayState.isFromCurrentMonth) GoPaddiNeutral200 else Color.Transparent
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 0.dp
                ),
                border = BorderStroke(
                    width = if (isSelected) 1.dp else 0.dp,
                    color = if (isSelected) GoPaddiBlue600 else Color.Transparent
                )
            ) {
                Text(
                    modifier = Modifier
                        .padding(8.dp)
                        .align(Alignment.CenterHorizontally),
                    fontFamily = FontFamily(Font(R.font.satoshi_medium)),
                    style = SatoshiTypography.titleMedium.copy(
                        color = if (dayState.isFromCurrentMonth) GoPaddiBlack100 else GoPaddiBlack15,
                        fontSize = 17.sp
                    ),
                    textAlign = TextAlign.Center,
                    text = dayState.date.dayOfMonth.toString(),
                    fontWeight = FontWeight.W200
                )
            }
        }
    )
}


@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    name = "Dark Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "Light Mode",
    showBackground = true,
    uiMode = UI_MODE_NIGHT_NO
)
@Composable
fun PreviewSelectDateScreen() {
    GoPaddiTestAppTheme {
        SelectDateScreen(
            rememberNavController()
        )
    }
}