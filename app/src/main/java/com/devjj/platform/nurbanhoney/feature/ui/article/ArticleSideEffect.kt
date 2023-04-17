package com.devjj.platform.nurbanhoney.feature.ui.article

sealed class ArticleSideEffect {
	data class ShowToast(val message: String) :
		ArticleSideEffect()
}