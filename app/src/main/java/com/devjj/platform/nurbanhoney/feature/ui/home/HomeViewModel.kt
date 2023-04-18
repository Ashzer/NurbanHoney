package com.devjj.platform.nurbanhoney.feature.ui.home

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.viewModelScope
import com.devjj.platform.nurbanhoney.core.platform.BaseViewModel
import com.devjj.platform.nurbanhoney.domain.article.GetArticlesUseCase
import com.devjj.platform.nurbanhoney.domain.article.model.ArticlePreview
import com.devjj.platform.nurbanhoney.domain.board.GetBoardUseCase
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.feature.ui.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
import org.orbitmvi.orbit.syntax.simple.blockingIntent
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.postSideEffect
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
@Inject constructor(
	private val savedStateHandle: SavedStateHandle,
	private val getBoardUseCase: GetBoardUseCase,
	private val getArticlesUseCase: GetArticlesUseCase
) : ContainerHost<HomeState, HomeSideEffect>, BaseViewModel() {
	override val container = container<HomeState, HomeSideEffect>(HomeState())

//	private val boards by lazy{ savedStateHandle.get<List<Board>>("boards") ?: listOf()}

	init {
		fetchData()
	}

	private fun fetchData() {
		getBoards()
	}

	private fun getBoards() {
		intent {
			viewModelScope.launch(Dispatchers.IO) {
				reduce { state.copy(state = UiState.Loading) }
				getBoardUseCase(UseCase.None()) { it.fold(::handleBoards, ::handleFailure) }
			}
		}
	}

	private fun getArticle(
		boardName: String = "nurban",
		flag: Int = 0,
		offset: Int = 0,
		limit: Int = 10
	) {
		intent {
			viewModelScope.launch(Dispatchers.IO) {
				reduce {
					state.copy(
						state = UiState.Loading,
						selectedBoardIndex = state.boards?.map { it.address }?.indexOf(boardName)
							?: 0
					)
				}
				getArticlesUseCase(
					GetArticlesUseCase.Params(
						boardName,
						flag,
						offset,
						limit
					)
				) { it.fold(::handleArticles, ::handleFailure) }
			}
		}
	}

	@OptIn(OrbitExperimental::class)
	private fun handleArticles(articlePreviews: List<ArticlePreview>) = intent {
		Log.d("handleArticle", articlePreviews.toString())
		reduce {
//			blockingIntent { Thread.sleep(1000) }
			state.copy(state = UiState.Success, articlePreviews = articlePreviews)
		}
	}

	private fun handleBoards(boards: List<Board>) =
		intent {
			reduce {
				getArticle()
				state.copy(state = UiState.Success, boards = boards)
			}
		}

	private fun handleFailure(failure: Throwable) =
		intent { reduce { state.copy(state = UiState.Failed("Error")) } }

	fun onTabSelected(index: Int) {
		intent {

			if (state.state != UiState.Loading) {
				if (index != state.selectedBoardIndex) {
					getArticle(boardName = state.boards?.get(index)?.address ?: "")
				}
				reduce {
					Log.d("onTabSelected-before", state.selectedBoardIndex.toString())
					state.copy(selectedBoardIndex = index)
				}
			}
			Log.d("onTabSelected-after", state.selectedBoardIndex.toString())
		}
	}

	fun onArticleClicked(id: Int) {
		intent {
			postSideEffect(
				HomeSideEffect.ShowArticleDetail(
					state.boards?.get(state.selectedBoardIndex)?.address ?: "",
					id
				)
			)
		}
	}
}
