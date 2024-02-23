package com.local.archexample.domain.usecase

import com.local.archexample.domain.repository.DomainRepositoryImpl
import com.local.archexample.data.models.ImageData
import javax.inject.Inject

class FloofUseCase @Inject constructor(private val repositoryImpl: DomainRepositoryImpl) {
    suspend fun floof(): Result<ImageData> {
        return repositoryImpl.floof()
    }
}