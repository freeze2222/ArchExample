package com.local.archexample.view.screens.first

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.local.archexample.domain.usecase.FloofUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FirstScreenViewModel @Inject constructor(private val useCase: FloofUseCase) : ViewModel() {
    private val _state = MutableStateFlow(FirstScreenState())
    val state: StateFlow<FirstScreenState>
        get() = _state.asStateFlow()

    init {
        floof()
    }

    fun floof() {
        viewModelScope.launch {
            val data = useCase.floof()
            if (data.isFailure) {
                _state.tryEmit(FirstScreenState(false, null, data.exceptionOrNull().toString()))
                return@launch
            }
            _state.tryEmit(FirstScreenState(false, data.getOrThrow()))
        }
    }
}