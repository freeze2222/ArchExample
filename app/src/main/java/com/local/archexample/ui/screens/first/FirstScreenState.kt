package com.local.archexample.view.screens.first

import com.local.archexample.data.models.ImageData

data class FirstScreenState(
    var isLoading: Boolean = true,
    var data: ImageData? = null,
    var error: String? = null
)
