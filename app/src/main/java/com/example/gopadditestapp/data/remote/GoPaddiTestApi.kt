package com.example.gopadditestapp.data.remote

import com.example.gopadditestapp.data.model.TripInformation
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface GoPaddiTestApi {

    @GET("/api/trips")
    suspend fun getTrips(
    ): List<TripInformation>


    @POST("/api/trips")
    suspend fun createTrip(
        @Body tripInfoDTO : TripInformation
    ) : TripInformation


    companion object {
        val BASE_URL = "https://cac814b6f244a8e42689.free.beeceptor.com"
    }
}