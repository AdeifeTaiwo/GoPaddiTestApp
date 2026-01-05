package com.example.gopadditestapp.navigation

import androidx.navigation.NavController
import com.example.gopadditestapp.data.model.City
import com.example.gopadditestapp.data.model.TripInformation
import com.example.gopadditestapp.navigation.BundleKeys.CITY_INFORMATION
import com.example.gopadditestapp.navigation.BundleKeys.TRIP_INFORMATION

enum class Screens(private val args: List<String>? = null) {
    Menu,
    Signup,
    SplashScreen(),
    GoPaddiHomeScreen(),
    SelectCityScreen(),
    SelectDateScreen(),
    PlanTripDetailsScreen()
}


object GetNavigationBundle {
    inline fun <reified T> NavController.getNavigationArgument(key: String): T? {
        return this.previousBackStackEntry?.savedStateHandle?.get(key)
    }

    fun NavController.getTripInformation(): TripInformation? {
        return getNavigationArgument<TripInformation>(TRIP_INFORMATION)
    }

    fun NavController.getCityInformation(): City? {
        return getNavigationArgument<City>(CITY_INFORMATION)
    }

}

object SetNavigationBundle {
    private fun NavController.setNavigationArgument(key: String, value: Any?) {
        this.currentBackStackEntry?.savedStateHandle?.set(key, value)
    }

    fun NavController.setTripInformation(item: TripInformation) {
        setNavigationArgument(TRIP_INFORMATION, item)
    }


    fun NavController.setCityInformation(item: City) {
        setNavigationArgument(CITY_INFORMATION, item)
    }
}

object BundleKeys {
    const val TRIP_INFORMATION = "tripInformation"
    const val CITY_INFORMATION = "cityInformation"
}
