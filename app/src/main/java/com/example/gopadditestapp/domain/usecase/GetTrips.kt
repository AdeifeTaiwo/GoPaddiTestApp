package com.example.gopadditestapp.domain.usecase

import com.example.gopadditestapp.data.model.TripInformation
import com.example.gopadditestapp.domain.repository.GoPaddiTestRepository
import com.example.gopadditestapp.utils.Resource
import kotlinx.coroutines.flow.Flow

class GetTrips(private val goPaddiTestRepository: GoPaddiTestRepository) {
    suspend operator fun invoke(): Flow<Resource<List<TripInformation>>> {
        return goPaddiTestRepository.getTrips()
    }
}