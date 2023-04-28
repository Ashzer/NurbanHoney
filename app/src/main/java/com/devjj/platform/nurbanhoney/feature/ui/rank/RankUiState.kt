package com.devjj.platform.nurbanhoney.feature.ui.rank

sealed class RankUiState {
	object Init : RankUiState()
	object RankLoading : RankUiState()
	object RankSuccess : RankUiState()
}