package com.example.gopadditestapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
data class TripInformation(
    val startDate: String,
    val endDate: String,
    val tripName: String,
    val tripDescription: String,
    val travelStyle: String,
    val tripDate: String,
    val tripDuration: String,
    val longitude: Double,
    val latitude: Double,
    val city: String,
    val country: String,
    val airport: String,
    val countryCode: String,
    val flag: String

): Parcelable

val sampleTripList = listOf(
    TripInformation(
        startDate = "2026-02-10",
        endDate = "2026-02-15",
        tripName = "Lagos Beach Getaway",
        tripDescription = "Relaxing beach vacation with ocean views and sunset cruises.",
        travelStyle = "Leisure",
        tripDate = "19th Feb, 2026",
        tripDuration = "5 Days",
        longitude = 3.3792,
        latitude = 6.5244,
        city = "Lagos",
        country ="Nigeria",
        airport = "Muritala Muhammed Airport",
        countryCode = "NG",
        flag = "NG",
    ),
    TripInformation(
        startDate = "2026-04-01",
        endDate = "2026-04-07",
        tripName = "Dubai City Adventure",
        tripDescription = "Explore skyscrapers, desert safari, and luxury shopping.",
        travelStyle = "Adventure",
        tripDate = "19th April, 2026",
        tripDuration = "6 Days",
        longitude = 55.2708,
        latitude = 25.2048,
        city = "Lagos",
        country ="Nigeria",
        airport = "Muritala Muhammed Airport",
        countryCode = "NG",
        flag = "NG",
    ),
    TripInformation(
        startDate = "2026-08-20",
        endDate = "2026-08-30",
        tripName = "Paris Cultural Tour",
        tripDescription = "Museums, art galleries, cafes, and historic landmarks.",
        travelStyle = "Cultural",
        tripDate = "19th August, 2026",
        tripDuration = "10 Days",
        longitude = 2.3522,
        latitude = 48.8566,
        city = "Lagos",
        country ="Nigeria",
        airport = "Muritala Muhammed Airport",
        countryCode = "NG",
        flag = "NG",
    )
)
