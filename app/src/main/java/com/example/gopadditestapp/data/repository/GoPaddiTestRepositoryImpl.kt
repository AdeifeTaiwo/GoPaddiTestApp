package com.example.gopadditestapp.data.repository

import com.example.gopadditestapp.data.model.TripInformation
import com.example.gopadditestapp.data.remote.GoPaddiTestApi
import com.example.gopadditestapp.domain.repository.GoPaddiTestRepository
import com.example.gopadditestapp.utils.Resource
import com.example.gopadditestapp.utils.StringUtils
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GoPaddiTestRepositoryImpl @Inject constructor(
    private val goPaddiTestApi: GoPaddiTestApi,
) : GoPaddiTestRepository {

    override suspend fun getTrips(): Flow<Resource<List<TripInformation>>>  = flow {
        emit(Resource.Loading())
        try {
            val response = goPaddiTestApi.getTrips()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error(getErrorMessage( exception = e)))
        }
        return@flow
    }

    override suspend fun createTrips(tripInformation: TripInformation): Flow<Resource<TripInformation>> = flow {
        emit(Resource.Loading())
        try {
            val response = goPaddiTestApi.createTrip(tripInformation)
            emit(Resource.Success(response))
        } catch (e: Exception) {
            e.printStackTrace()
            emit(Resource.Error(getErrorMessage( exception = e)))
        }
        return@flow
    }


    private fun getErrorMessage(exception: Exception): String {
        return when (exception) {
            is HttpException -> return if (exception.code() == 400) {
                val errorBodyString = exception.response()?.errorBody()?.string()
                val message = StringUtils.getErrorBodyMessage(errorBodyString ?: "")
                message

            } else if(exception.code() == 404 || exception.code() == 500) {
                "Something went wrong, Please Try again Later"
            } else {
                "Something went wrong, Please Try again Later"
            }

            is IOException -> "We encountered a problem while processing your request, Please Try again Later"

            else ->  "We encountered a problem while processing your request, Please Try again Later"
        }
    }


}