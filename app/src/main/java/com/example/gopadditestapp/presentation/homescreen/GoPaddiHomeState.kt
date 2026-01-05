package com.example.gopadditestapp.presentation.homescreen

import com.example.gopadditestapp.data.model.TripInformation

data class GoPaddiHomeState(
    val isLoading: Boolean = false,
    val myTrips: List<TripInformation> = emptyList(),
    val hasError: Boolean = false,
    val errorMessage: String = ""
)
