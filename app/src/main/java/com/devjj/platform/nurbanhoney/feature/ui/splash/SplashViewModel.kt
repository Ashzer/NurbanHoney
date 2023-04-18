package com.devjj.platform.nurbanhoney.feature.ui.splash

import com.devjj.platform.nurbanhoney.core.platform.BaseViewModel
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.feature.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class SplashViewModel
@Inject constructor() : ContainerHost<SplashState, SplashSideEffect>, BaseViewModel() {
	override val container = container<SplashState, SplashSideEffect>(SplashState())
}

data class SplashState(
	val state: UiState = UiState.Loading,
	val boards: List<Board>? = null,
)

sealed class SplashSideEffect {
	data class ShowToast(val message: String) : SplashSideEffect()
}