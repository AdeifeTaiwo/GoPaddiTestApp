package com.example.gopadditestapp.presentation.homescreen

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
class GoPaddiHomeViewModel @Inject constructor(
    val app: Application,
    val tripUseCase: TripUseCase
) : ViewModel() {

    private var _uiState = MutableStateFlow(GoPaddiHomeState())
    val uiState = _uiState.asStateFlow()

    init {
        getTrips()
    }

    fun getTrips(showLoader: Boolean = true) {
        viewModelScope.launch {
            tripUseCase.getTrips().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        delay(2000)
                        result.data.let { tripList ->
                            tripList?.let {
                                _uiState.update {
                                    it.copy(
                                        isLoading = false,
                                        myTrips = tripList
                                    )
                                }
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
                                isLoading = showLoader,
                                hasError = false,
                                errorMessage = ""
                            )
                        }
                    }

                }
            }
        }
    }
}