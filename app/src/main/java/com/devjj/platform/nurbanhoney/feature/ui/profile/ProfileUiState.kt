package com.devjj.platform.nurbanhoney.feature.ui.profile

sealed class ProfileUiState {
	object Loading : ProfileUiState()
	object Success : ProfileUiState()
	object TokenFailed : ProfileUiState()
	data class Failed(val message: String) : ProfileUiState()
}