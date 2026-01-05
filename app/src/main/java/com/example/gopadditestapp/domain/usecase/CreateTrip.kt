package com.example.gopadditestapp.domain.usecase

import com.example.gopadditestapp.data.model.TripInformation
import com.example.gopadditestapp.domain.repository.GoPaddiTestRepository
import com.example.gopadditestapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class CreateTrip(private val goPaddiTestRepository: GoPaddiTestRepository) {
    suspend operator fun invoke(tripInformation: TripInformation): Flow<Resource<TripInformation>> {
        return goPaddiTestRepository.createTrips(tripInformation)
    }
}