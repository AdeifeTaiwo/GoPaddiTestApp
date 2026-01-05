package com.example.gopadditestapp.presentation.selectdate

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gopadditestapp.data.model.TripInformation
import com.example.gopadditestapp.domain.usecase.TripUseCase
import com.example.gopadditestapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CreateTripViewModel @Inject constructor(
    val app: Application,
    val tripUseCase: TripUseCase
) : ViewModel() {
    private var _uiState = MutableStateFlow(CreateTripState())
    val uiState = _uiState.asStateFlow()


    fun createTrip(tripInformation: TripInformation) {
        viewModelScope.launch {
            tripUseCase.createTrip(tripInformation).collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        delay(2000)
                        result.data.let { tripInfo->
                            _uiState.update {
                                it.copy(
                                    isLoading = false,
                                   tripInformation
                                )
                            }
                        }
                    }

                    is Resource.Error -> {
                        _uiState.update {
                            it.copy(
                                isLoading = false,
                                hasError = true,
                                errorMessage = it.errorMessage
                            )
                        }
                    }

                    is Resource.Loading -> {
                        _uiState.update {
                            it.copy(
                                isLoading = true,
                                hasError = false,
                                errorMessage = ""
                            )
                        }
                    }

                }
            }
        }
    }

    fun dismissErrorDialog(){
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                    hasError = false
                )
            }
        }
    }

    fun dismissSuccessDialog(){
        viewModelScope.launch {
            _uiState.update {
                it.copy(
                   myTrips = null
                )
            }
        }
    }
}