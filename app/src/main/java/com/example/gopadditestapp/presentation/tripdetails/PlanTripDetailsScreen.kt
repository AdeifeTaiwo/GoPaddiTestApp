package com.example.gopadditestapp.presentation.tripdetails

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gopadditestapp.R
import com.example.gopadditestapp.component.GoPaddiAppBarBlack
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme

@Composable
fun PlanTripDetailsScreen(navController: NavController) {
    Scaffold(
        topBar = { GoPaddiAppBarBlack(titleText = "Plan A Trip") {
            navController.popBackStack()
        } }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState())
        ) {
            Column(modifier = Modifier
                .padding(horizontal = 0.dp)
                .fillMaxWidth()
            ) {
                Spacer(modifier = Modifier.padding(top = 10.dp))
                Image(
                    modifier = Modifier.fillMaxWidth(),
                    painter = painterResource(R.drawable.tripdetailslogo),
                    contentDescription = "Trip Details",
                    contentScale = ContentScale.Crop
                )
            }
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
fun PreviewSelectCityScreen() {
    GoPaddiTestAppTheme {
        PlanTripDetailsScreen(rememberNavController())
    }
}
