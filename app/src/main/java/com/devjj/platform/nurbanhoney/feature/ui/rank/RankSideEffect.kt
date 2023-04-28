package com.devjj.platform.nurbanhoney.feature.ui.rank

sealed class RankSideEffect {
	data class ShowToast(val message: String) : RankSideEffect()
}