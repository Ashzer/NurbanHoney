package com.devjj.platform.nurbanhoney.feature.ui.login

import com.devjj.platform.nurbanhoney.core.platform.BaseViewModel
import com.devjj.platform.nurbanhoney.domain.login.LoginRequestUseCase
import com.devjj.platform.nurbanhoney.domain.login.model.NurbanToken
import com.devjj.platform.nurbanhoney.domain.profile.GetProfileUseCase
import com.kakao.sdk.auth.model.OAuthToken
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
	val loginRequestUseCase: LoginRequestUseCase
) : ContainerHost<LoginState, LoginSideEffect>, BaseViewModel() {
	override val container = container<LoginState, LoginSideEffect>(LoginState())

	fun onKakaoLoginResult(callback: Result<OAuthToken>) {
		callback.fold(
			::handleKakaoLoginSuccess,
			::handleKakaoLoginFailure
		)

	}

	private fun handleKakaoLoginSuccess(token: OAuthToken) {
		intent {
			reduce { state.copy(state = LoginUiState.Loading) }
			loginRequestUseCase(LoginRequestUseCase.Params("kakao", token.accessToken)) {
				it.fold(
					::handleLoginRequestSuccess,
					::handleLoginRequestFailure
				)
			}

		}
	}

	private fun handleLoginRequestSuccess(token: NurbanToken) {
		intent {
			reduce { state.copy(state = LoginUiState.Success) }
			postSideEffect(LoginSideEffect.BackStack)
		}
	}

	private fun handleLoginRequestFailure(failure: Throwable) {
		intent {
			reduce { state.copy(state = LoginUiState.Error("login")) }
		}
	}

	private fun handleKakaoLoginFailure(failure: Throwable) {
		intent {
			reduce { state.copy(state = LoginUiState.Error("kakao")) }
		}
	}
}

sealed class LoginSideEffect {
	object BackStack : LoginSideEffect()
	object CancelLogin : LoginSideEffect()
}