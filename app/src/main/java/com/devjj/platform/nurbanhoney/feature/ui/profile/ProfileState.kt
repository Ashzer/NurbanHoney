package com.devjj.platform.nurbanhoney.feature.ui.profile

import com.devjj.platform.nurbanhoney.domain.profile.model.Profile

data class ProfileState(
	val state: ProfileUiState = ProfileUiState.Loading,
	val profile: Profile? = null
)