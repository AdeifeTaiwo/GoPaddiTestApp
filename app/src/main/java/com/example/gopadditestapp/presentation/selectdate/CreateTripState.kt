package com.example.gopadditestapp.presentation.selectdate

import com.example.gopadditestapp.data.model.TripInformation

data class CreateTripState(
    val isLoading: Boolean = false,
    val myTrips: TripInformation? = null,
    val hasError: Boolean = false,
    val errorMessage: String = ""
)
