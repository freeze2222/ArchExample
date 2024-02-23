package com.local.archexample.domain.repository

import com.local.archexample.data.models.ImageData
import com.local.archexample.di.RetrofitModule
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class DomainRepositoryImpl @Inject constructor() : DomainRepository {
    companion object {
        // TODO
    }

    override suspend fun floof(): Result<ImageData> {
        return withContext(Dispatchers.IO) {
            val raw = RetrofitModule.provideRetrofit().floof().execute()
            if (!raw.isSuccessful) {
                return@withContext Result.failure<ImageData>(Exception(raw.code().toString()))
            }
            return@withContext Result.success(raw.body()!!)
        }
    }
}
