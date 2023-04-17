package com.devjj.platform.nurbanhoney.feature.ui.article

import com.devjj.platform.nurbanhoney.domain.article.model.Article
import com.devjj.platform.nurbanhoney.domain.article.model.Comment
import com.devjj.platform.nurbanhoney.feature.ui.UiState

data class ArticleState(
	val state: UiState = UiState.Loading,
	val article: Article? = null,
	val comments: List<Comment> = listOf()
)