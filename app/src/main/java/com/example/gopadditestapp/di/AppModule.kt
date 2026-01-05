package com.example.gopadditestapp.di

import com.example.gopadditestapp.data.remote.GoPaddiTestApi
import com.example.gopadditestapp.domain.repository.GoPaddiTestRepository
import com.example.gopadditestapp.domain.usecase.CreateTrip
import com.example.gopadditestapp.domain.usecase.GetTrips
import com.example.gopadditestapp.domain.usecase.TripUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val interceptor: HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val client: OkHttpClient =
        OkHttpClient().newBuilder().addInterceptor(interceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()

    @Provides
    @Singleton
    fun providesGoPaddiApi(): GoPaddiTestApi {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(GoPaddiTestApi.BASE_URL)
            .client(client)
            .build()
            .create(GoPaddiTestApi::class.java)
    }


    @Provides
    @Singleton
    fun providesTripUseCases(
        goPaddiTestRepository: GoPaddiTestRepository
    ): TripUseCase {
        return TripUseCase(
            getTrips = GetTrips(goPaddiTestRepository),
            createTrip = CreateTrip(goPaddiTestRepository)

        )
    }
}