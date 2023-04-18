package com.devjj.platform.nurbanhoney.feature.ui.article

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.devjj.platform.nurbanhoney.core.platform.BaseViewModel
import com.devjj.platform.nurbanhoney.domain.article.GetArticleUseCase
import com.devjj.platform.nurbanhoney.domain.article.model.Article
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.feature.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel
@Inject constructor(
	private val savedStateHandle: SavedStateHandle,
	private val getArticle: GetArticleUseCase
) : ContainerHost<ArticleState, ArticleSideEffect>, BaseViewModel() {
	override val container = container<ArticleState, ArticleSideEffect>(ArticleState())
	private val board by lazy { savedStateHandle.get<String>("board").orEmpty() }
	private val id by lazy { savedStateHandle.get<String>("id")?.toInt() ?: 0 }

	init {
		getArticle()
	}

	private fun getArticle() {
		Log.d("ArticleViewModel", "board = $board, id = $id")
		intent {
			viewModelScope.launch(Dispatchers.IO) {
				getArticle(
					GetArticleUseCase.Params(
						board,
						"",
						id
					)
				) {
					it.fold(
						::handleArticle,
						::handleFailure
					)
				}
			}
		}
	}

	private fun handleArticle(article: Article) = intent {
		reduce {
			Log.d("ArticleViewModel", "article = $article")
			state.copy(
				state = UiState.Success,
				article = article
			)
		}
	}

	private fun handleFailure(failure: Throwable) = intent {
		reduce {
			state.copy(state = UiState.Failed("Error"))
		}
	}
}
