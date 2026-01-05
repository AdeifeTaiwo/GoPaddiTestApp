package com.example.gopadditestapp.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize

data class City(
    val city: String,
    val country: String,
    val airport: String,
    val countryCode: String,
    val flag: String
): Parcelable

val cities = listOf(
    City("Lagos", "Nigeria", "Murtala Muhammed", "NG", "🇳🇬"),
    City("Abuja", "Nigeria", "Nnamdi Azikiwe", "NG", "🇳🇬"),
    City("Port Harcourt", "Nigeria", "Port Harcourt Intl", "NG", "🇳🇬"),
    City("Accra", "Ghana", "Kotoka Intl", "GH", "🇬🇭"),
    City("Nairobi", "Kenya", "Jomo Kenyatta Intl", "KE", "🇰🇪"),
    City("Cairo", "Egypt", "Cairo Intl", "EG", "🇪🇬"),
    City("Johannesburg", "South Africa", "O. R. Tambo Intl", "ZA", "🇿🇦"),
    City("Cape Town", "South Africa", "Cape Town Intl", "ZA", "🇿🇦"),
    City("Casablanca", "Morocco", "Mohammed V Intl", "MA", "🇲🇦"),
    City("Algiers", "Algeria", "Houari Boumediene", "DZ", "🇩🇿"),
    City("Laghouat", "Algeria", "Laghouat", "DZ", "🇩🇿"),

    City("Doha", "Qatar", "Hamad Intl", "QA", "🇶🇦"),
    City("Dubai", "United Arab Emirates", "Dubai Intl", "AE", "🇦🇪"),
    City("Abu Dhabi", "United Arab Emirates", "Zayed Intl", "AE", "🇦🇪"),
    City("Riyadh", "Saudi Arabia", "King Khalid Intl", "SA", "🇸🇦"),
    City("Jeddah", "Saudi Arabia", "King Abdulaziz Intl", "SA", "🇸🇦"),
    City("Kuwait City", "Kuwait", "Kuwait Intl", "KW", "🇰🇼"),
    City("Muscat", "Oman", "Muscat Intl", "OM", "🇴🇲"),

    City("London", "United Kingdom", "Heathrow", "UK", "🇬🇧"),
    City("London", "United Kingdom", "Gatwick", "UK", "🇬🇧"),
    City("Manchester", "United Kingdom", "Manchester Intl", "UK", "🇬🇧"),
    City("Paris", "France", "Charles de Gaulle", "FR", "🇫🇷"),
    City("Amsterdam", "Netherlands", "Schiphol", "NL", "🇳🇱"),
    City("Frankfurt", "Germany", "Frankfurt Intl", "DE", "🇩🇪"),
    City("Munich", "Germany", "Munich Intl", "DE", "🇩🇪"),
    City("Rome", "Italy", "Leonardo da Vinci", "IT", "🇮🇹"),
    City("Madrid", "Spain", "Barajas", "ES", "🇪🇸"),

    City("New York", "United States", "JFK Intl", "US", "🇺🇸"),
    City("New York", "United States", "LaGuardia", "US", "🇺🇸"),
    City("Los Angeles", "United States", "LAX", "US", "🇺🇸"),
    City("Chicago", "United States", "O'Hare Intl", "US", "🇺🇸"),
    City("Atlanta", "United States", "Hartsfield–Jackson", "US", "🇺🇸"),
    City("Toronto", "Canada", "Pearson Intl", "CA", "🇨🇦"),
    City("Vancouver", "Canada", "Vancouver Intl", "CA", "🇨🇦"),

    City("Beijing", "China", "Capital Intl", "CN", "🇨🇳"),
    City("Shanghai", "China", "Pudong Intl", "CN", "🇨🇳"),
    City("Tokyo", "Japan", "Haneda", "JP", "🇯🇵"),
    City("Seoul", "South Korea", "Incheon Intl", "KR", "🇰🇷"),
    City("Singapore", "Singapore", "Changi", "SG", "🇸🇬"),
    City("Bangkok", "Thailand", "Suvarnabhumi", "TH", "🇹🇭"),
    City("Mumbai", "India", "Chhatrapati Shivaji", "IN", "🇮🇳"),
    City("Delhi", "India", "Indira Gandhi Intl", "IN", "🇮🇳")
)
