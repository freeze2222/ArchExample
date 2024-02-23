package com.local.archexample.data.utils

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
    fun provideRetrofit(): ExampleApi {
        return Retrofit.Builder()
            .baseUrl("https://randomfox.ca")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExampleApi::class.java)
    }
}