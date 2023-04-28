package com.devjj.platform.nurbanhoney.feature.ui.profile

import android.util.Log
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
//
//	init {
//		fetchData()
//	}

	fun fetchData(token :String) {
		getProfile(token)
	}

	private fun getProfile(token :String) {

		viewModelScope.launch(Dispatchers.IO) {
			getProfileUseCase(GetProfileUseCase.Params(token)) {
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
			Log.d("ProfileViewModel", "handleFailure: ${failure.javaClass}")
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

