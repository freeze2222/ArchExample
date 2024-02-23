package com.local.archexample.domain.repository

import com.local.archexample.data.models.ImageData

interface DomainRepository {
    suspend fun floof(): Result<ImageData>
}