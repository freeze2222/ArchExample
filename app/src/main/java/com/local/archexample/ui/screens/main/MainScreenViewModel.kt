package com.local.archexample.ui.screens.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.local.archexample.domain.usecase.FloofUseCase
import com.local.archexample.view.screens.first.MainScreenState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainScreenViewModel @Inject constructor(private val useCase: FloofUseCase) : ViewModel() {
    private val _state = MutableStateFlow(MainScreenState())
    val state: StateFlow<MainScreenState>
        get() = _state.asStateFlow()

    init {
        floof()
    }

    fun floof() {
        viewModelScope.launch {
            _state.tryEmit(MainScreenState(true, null))
            val data = useCase.floof()
            if (data.isFailure) {
                _state.tryEmit(MainScreenState(false, null, data.exceptionOrNull().toString()))
                return@launch
            }
            _state.tryEmit(MainScreenState(false, data.getOrThrow()))
        }
    }
}