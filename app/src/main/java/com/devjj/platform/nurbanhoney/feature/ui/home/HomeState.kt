package com.devjj.platform.nurbanhoney.feature.ui.home

import com.devjj.platform.nurbanhoney.domain.article.model.ArticlePreview
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.feature.ui.UiState

data class HomeState(
	val state: HomeUiState = HomeUiState.Init,
	val boards: List<Board>? = null,
	val selectedBoardIndex: Int? = null,
	val articlePreviews: List<ArticlePreview>? = null
)
