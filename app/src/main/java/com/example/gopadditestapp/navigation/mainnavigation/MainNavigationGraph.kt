package com.example.gopadditestapp.navigation.mainnavigation

import android.app.Activity
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.gopadditestapp.navigation.Graph
import com.example.gopadditestapp.navigation.Screens
import com.example.gopadditestapp.navigation.SetNavigationBundle.setCityInformation
import com.example.gopadditestapp.presentation.homescreen.GoPaddiHomeViewModel
import com.example.gopadditestapp.presentation.homescreen.HomeScreen
import com.example.gopadditestapp.presentation.selectcity.SelectCityScreen
import com.example.gopadditestapp.presentation.selectdate.SelectDateScreen
import com.example.gopadditestapp.presentation.splash.SplashScreen
import com.example.gopadditestapp.presentation.tripdetails.PlanTripDetailsScreen


@RequiresApi(Build.VERSION_CODES.O)
fun NavGraphBuilder.mainGraph(
    activity: Activity,
    navHostController: NavHostController,

    ) {


    navigation(route = Graph.MAIN, startDestination = Screens.SplashScreen.name) {

        composable(Screens.SplashScreen.name) {
            SplashScreen(navHostController)
        }

        composable(Screens.GoPaddiHomeScreen.name) {


            HomeScreen(
                navHostController,
                onCreateTrip = {
                    navHostController.navigate(Screens.SelectCityScreen.name)
                }
            )
        }

        composable(Screens.SelectCityScreen.name) {
            SelectCityScreen(
                navHostController,{ city ->
                    navHostController.setCityInformation(city)
                    navHostController.navigate(Screens.SelectDateScreen.name)
                }
            )
        }

        composable(Screens.SelectDateScreen.name) {
            SelectDateScreen(
                navHostController,
            )
        }

        composable(Screens.PlanTripDetailsScreen.name) {
            PlanTripDetailsScreen(
                navHostController,
            )
        }

    }
}

