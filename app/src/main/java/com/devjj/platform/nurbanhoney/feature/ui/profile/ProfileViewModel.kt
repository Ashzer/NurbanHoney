package com.devjj.platform.nurbanhoney.feature.ui.profile

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.devjj.platform.nurbanhoney.core.platform.BaseViewModel
import com.devjj.platform.nurbanhoney.domain.profile.GetProfileUseCase
import com.devjj.platform.nurbanhoney.domain.profile.model.Profile
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel
@Inject constructor(
	val getProfileUseCase: GetProfileUseCase
) : ContainerHost<ProfileState, ProfileSideEffect>, BaseViewModel() {
	override val container = container<ProfileState, ProfileSideEffect>(ProfileState())

	init {
		fetchData()
	}

	private fun fetchData() {
		getProfile()
	}

	private fun getProfile() {

		viewModelScope.launch(Dispatchers.IO) {
			getProfileUseCase(GetProfileUseCase.Params("token")) {
				it.fold(
					::handleProfile,
					::handleFailure
				)
			}
		}
	}

	private fun handleProfile(profile: Profile) {
		intent {
			reduce { state.copy(state = ProfileUiState.Success, profile = profile) }
		}
	}

	private fun handleFailure(failure: Throwable) {
		intent {
			Log.d("ProfileViewModel", "handleFailure: ${failure.message}")
			when (failure) {
				is Failure.TokenFailure -> {
					postSideEffect(ProfileSideEffect.RequestLogin)
				}
				else -> {
					reduce { state.copy(state = ProfileUiState.Failed("fail")) }
				}
			}

		}
	}

}

data class ProfileState(
	val state: ProfileUiState = ProfileUiState.Loading,
	val profile: Profile? = null
)

sealed class ProfileSideEffect {
	object RequestLogin : ProfileSideEffect()
}

sealed class ProfileUiState {
	object Loading : ProfileUiState()
	object Success : ProfileUiState()
	object TokenFailed : ProfileUiState()
	data class Failed(val message: String) : ProfileUiState()
}
