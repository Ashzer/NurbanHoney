package com.devjj.platform.nurbanhoney.feature.ui.article

import com.devjj.platform.nurbanhoney.domain.article.model.Article
import com.devjj.platform.nurbanhoney.domain.article.model.Comment
import com.devjj.platform.nurbanhoney.feature.ui.UiState

data class ArticleState(
	val state: UiState = UiState.Loading,
	val board : String = "",
	val article: Article = Article.empty,
	val comments: List<Comment> = listOf()
)