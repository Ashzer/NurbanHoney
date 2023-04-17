package com.devjj.platform.nurbanhoney.feature.ui

sealed class UiState {
    object Loading : UiState()
    object Success : UiState()
    data class Failed(val message: String) : UiState()
}