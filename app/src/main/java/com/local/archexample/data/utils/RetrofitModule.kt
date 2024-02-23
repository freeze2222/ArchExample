package com.local.archexample.di

import com.local.archexample.data.utils.MediationApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object RetrofitModule {
    @Provides
    @Singleton
    fun provideRetrofit(): MediationApi {
        return Retrofit.Builder()
            .baseUrl("https://randomfox.ca")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MediationApi::class.java)
    }
}