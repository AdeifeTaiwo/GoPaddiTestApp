package com.example.gopadditestapp.domain.repository

import com.example.gopadditestapp.data.model.TripInformation
import com.example.gopadditestapp.utils.Resource
import kotlinx.coroutines.flow.Flow

interface GoPaddiTestRepository {

    suspend fun getTrips(): Flow<Resource<List<TripInformation>>>

    suspend fun createTrips(tripInformation: TripInformation): Flow<Resource<TripInformation>>

}