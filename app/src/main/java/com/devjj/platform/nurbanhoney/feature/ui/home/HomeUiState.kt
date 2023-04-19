package com.devjj.platform.nurbanhoney.feature.ui.home

sealed class HomeUiState {
	object Init : HomeUiState()
	object BoardsLoading : HomeUiState()
	object BoardsSuccess : HomeUiState()
	object ArticlePreviewsLoading : HomeUiState()
	object ArticlePreviewsSuccess : HomeUiState()
	data class BoardFailed(val message: String) : HomeUiState()
	data class ArticlePreviewsFailed(val message: String) : HomeUiState()
	data class Failed(val message: String) : HomeUiState()
}