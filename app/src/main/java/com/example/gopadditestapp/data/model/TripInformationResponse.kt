package com.example.gopadditestapp.data.model

import com.google.gson.annotations.SerializedName

data class TripInformationResponse(

	@field:SerializedName("TripInformationResponse")
	val tripInformationResponse: List<TripInformationResponseItem?>? = null
)

data class TripInformationResponseItem(

	@field:SerializedName("travelStyle")
	val travelStyle: String? = null,

	@field:SerializedName("country")
	val country: String? = null,

	@field:SerializedName("flag")
	val flag: String? = null,

	@field:SerializedName("endDate")
	val endDate: String? = null,

	@field:SerializedName("city")
	val city: String? = null,

	@field:SerializedName("latitude")
	val latitude: Any? = null,

	@field:SerializedName("airport")
	val airport: String? = null,

	@field:SerializedName("tripDescription")
	val tripDescription: String? = null,

	@field:SerializedName("tripDate")
	val tripDate: String? = null,

	@field:SerializedName("countryCode")
	val countryCode: String? = null,

	@field:SerializedName("tripName")
	val tripName: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("tripDuration")
	val tripDuration: String? = null,

	@field:SerializedName("startDate")
	val startDate: String? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null
)
