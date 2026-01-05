package com.example.gopadditestapp.presentation.selectcity

import GoPaddiTextField
import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.gopadditestapp.R
import com.example.gopadditestapp.component.GoPaddiAppBarBlack
import com.example.gopadditestapp.data.model.City
import com.example.gopadditestapp.data.model.cities
import com.example.gopadditestapp.presentation.selectcity.components.CityRow
import com.example.gopadditestapp.ui.theme.GoPaddiTestAppTheme
import com.example.gopadditestapp.utils.getScreenHeight

@Composable
fun SelectCityScreen(
    navController: NavController,
    onSelectCity:(City) -> Unit
) {
    val cities = cities
    val screenHeight = getScreenHeight() * 0.8
    var selectedCity by remember { mutableStateOf(cities[0] ) }

    var searchQuery by remember { mutableStateOf("") }

    val filteredCitiesList = if (searchQuery.isBlank()) {
        cities.toSet().toList()
    } else {
        cities.filter { it.country.contains(searchQuery, ignoreCase = true) || it.airport.contains(searchQuery, ignoreCase = true) }
    }

    Scaffold(
        topBar = {
            Column {
                GoPaddiAppBarBlack(icon = R.drawable.ic_cancel, titleText = "Where") {
                    navController.popBackStack()
                }
                HorizontalDivider(thickness = 0.5.dp)
            }
        }
    ) { innerPadding ->
        Box(modifier = Modifier
            .padding(innerPadding)) {
            Column(modifier = Modifier.padding(16.dp)) {
                Spacer(modifier = Modifier.padding(top = 8.dp))
                GoPaddiTextField(
                    text = searchQuery,
                    onChange = {
                        searchQuery = it
                    }
                )

                LazyColumn(modifier = Modifier.height(screenHeight.dp)) {
                    items(
                        items = filteredCitiesList,
                        key = { it.city + it.countryCode + it.flag + it.country +it.airport }
                    ) { city ->
                        CityRow(city){
                            selectedCity = city
                            onSelectCity(selectedCity)
                        }
                    }
                }

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
        SelectCityScreen(
            rememberNavController()
        ){

        }
    }
}