package com.example.gopadditestapp.presentation.homescreen

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.pullrefresh.PullRefreshIndicator
import androidx.compose.material.pullrefresh.pullRefresh
import androidx.compose.material.pullrefresh.rememberPullRefreshState
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gopadditestapp.R
import com.example.gopadditestapp.component.AnimatedTypingText
import com.example.gopadditestapp.component.GoPaddiAppBarBlack
import com.example.gopadditestapp.component.GoPaddiCustomLoader
import com.example.gopadditestapp.component.GopaddiCreateTripDialog
import com.example.gopadditestapp.navigation.Screens
import com.example.gopadditestapp.presentation.homescreen.components.GoPaddiTripCard
import com.example.gopadditestapp.ui.theme.GoPaddiBlack100
import com.example.gopadditestapp.ui.theme.GoPaddiNeutral300
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import com.example.gopadditestapp.ui.theme.SatoshiTypography
import kotlinx.coroutines.delay


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeScreen(
    navController: NavController,
    onCreateTrip: () -> Unit
) {
    val homeScreenViewModel: GoPaddiHomeViewModel = hiltViewModel()
    val uiState = homeScreenViewModel.uiState.collectAsState().value

    var isRefreshing by remember { mutableStateOf(false) }
    val pullRefreshState = rememberPullRefreshState(
        refreshing = isRefreshing,
        onRefresh = {
            isRefreshing = true;

        }
    )

    LaunchedEffect(isRefreshing) {
        if (isRefreshing) {
            homeScreenViewModel.getTrips(false)
            delay(2000L)
            isRefreshing = false
        }
    }

    Scaffold(
        topBar = { GoPaddiAppBarBlack(titleText = "Plan A Trip") { } }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .pullRefresh(pullRefreshState)
                .verticalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier.padding(horizontal = 0.dp)) {

                Spacer(modifier = Modifier.padding(top = 10.dp))


                Box(
                    modifier = Modifier
                        .padding(vertical = 8.dp)
                        .height(550.dp)
                ) {
                    Box {
                        Image(
                            modifier = Modifier
                                .height(550.dp)
                                .fillMaxWidth(),
                            painter = painterResource(R.drawable.create_trip),
                            contentDescription = "Create Trip Image",
                            contentScale = ContentScale.FillBounds
                        )
                    }
                    Column(
                        modifier = Modifier
                            .padding(horizontal = 16.dp, vertical = 20.dp)
                            .fillMaxHeight(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        HomeScreenWelcomeText()
                        Spacer(modifier = Modifier.padding(top = 20.dp))

                        GopaddiCreateTripDialog {
                            onCreateTrip()
                        }

                    }
                }
                Spacer(modifier = Modifier.padding(top = 0.dp))
                Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 20.dp)) {
                    YourTripHeaderText()
                    Spacer(modifier = Modifier.padding(top = 8.dp))
                    PlannedTripHeaderBox()
                    uiState.myTrips.forEach { trip ->
                        GoPaddiTripCard(
                            tripInfo = trip,
                            onPreview = {
                                navController.navigate(Screens.PlanTripDetailsScreen.name)
                            }
                        )
                    }

                    if (uiState.myTrips.isEmpty()) {
                        Column(
                            modifier = Modifier
                                .height(300.dp)
                                .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center
                        ) {

                            Image(
                                painter = painterResource(R.drawable.empty_dashboard),
                                contentDescription = "",
                                colorFilter = ColorFilter.tint(Color.Gray)
                            )
                            Text(
                                fontFamily = FontFamily(Font(R.font.satoshi_regular)),
                                style = SatoshiTypography.titleMedium.copy(
                                    color = GoPaddiBlack100,
                                    fontSize = 16.sp
                                ),
                                text = "No Trips Details Found!!",
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }

            }

            if (uiState.isLoading) {
                GoPaddiCustomLoader {

                }
            }

            PullRefreshIndicator(
                refreshing = isRefreshing,
                state = pullRefreshState,
                modifier = Modifier
                    .align(Alignment.TopCenter)
                    .padding(top = 4.dp)
            )

        }
    }

}

@Composable
fun HomeScreenWelcomeText() {
    Column {
        Text(
            fontFamily = FontFamily(Font(R.font.satoshi_bold)),
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 20.sp
            ),
            text = "Plan Your Dream Trip in Minutes",
            fontWeight = FontWeight.W700
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        AnimatedTypingText(
            text = "Build, personalize, and optimize your itineraries with our trip planner. Perfect for getaways, remote workcations, and any spontaneous escapade.",
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 16.sp
            ),
        )
    }
}


@Composable
fun YourTripHeaderText() {
    Column {
        Text(
            fontFamily = FontFamily(Font(R.font.satoshi_bold)),
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 20.sp
            ),
            text = "Your Trips",
            fontWeight = FontWeight.W700
        )
        Spacer(modifier = Modifier.padding(top = 8.dp))
        Text(
            fontFamily = FontFamily(Font(R.font.satoshi_regular)),
            style = SatoshiTypography.titleMedium.copy(
                color = GoPaddiBlack100,
                fontSize = 16.sp
            ),
            text = "Your trip itineraries and  planned trips are placed here",
            fontWeight = FontWeight.Normal
        )
    }
}


@Composable
fun PlannedTripHeaderBox() {
    Surface(
        modifier = Modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp)),
        color = GoPaddiNeutral300
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 16.dp)
                .clip(RoundedCornerShape(4.dp))
                .background(Color.White)
                .padding(horizontal = 8.dp)
                .clip(RoundedCornerShape(4.dp)),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                modifier = Modifier.padding(vertical = 8.dp),
                fontFamily = FontFamily(Font(R.font.satoshi_bold)),
                style = SatoshiTypography.titleMedium.copy(
                    color = GoPaddiBlack100,
                    fontSize = 20.sp
                ),
                text = "Planned Trips",
                fontWeight = FontWeight.W700
            )

            Image(
                painter = painterResource(R.drawable.ic_caretdown), contentDescription = ""
            )
        }

    }
}

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
fun PreviewHomeScreen() {
    GoPaddiTestAppTheme {
        HomeScreen(
            rememberNavController(),
            {

            })
    }
}