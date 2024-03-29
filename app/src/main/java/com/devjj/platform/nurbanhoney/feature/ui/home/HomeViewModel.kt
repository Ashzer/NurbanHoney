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
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.annotation.OrbitExperimental
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
		intent { reduce { state.copy(state = HomeUiState.BoardsLoading) } }
		fetchBoards()
	}

	private fun fetchBoards(){
		intent {
			postSideEffect(HomeSideEffect.GetBoards)
		}

	}

	fun getBoards() {
		intent {
			viewModelScope.launch(Dispatchers.IO) {
				getBoardUseCase(UseCase.None()) { it.fold(::handleBoards, ::handleFailure) }
			}
		}
	}

	fun getArticles(
		boardName: String = "nurban",
		flag: Int = 0,
		offset: Int = 0,
		limit: Int = 10
	) {
		intent {
			viewModelScope.launch(Dispatchers.IO) {
				reduce {
					state.copy(
						state = HomeUiState.ArticlePreviewsLoading,
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
			state.copy(
				state = HomeUiState.ArticlePreviewsSuccess,
				articlePreviews = articlePreviews
			)
		}
	}

	private fun handleBoards(boards: List<Board>) =
		intent {
			reduce {
				getArticles()
				state.copy(state = HomeUiState.BoardsSuccess, boards = boards)
			}
		}

	private fun handleFailure(failure: Throwable) =
		intent {
			reduce {
				Log.d("handleFailure", "Error = ${failure.javaClass}")
				state.copy(state = HomeUiState.Failed("Error = ${failure.javaClass}"))
			}
		}

	fun onTabSelected(index: Int) {
		intent {

			if (state.state != HomeUiState.ArticlePreviewsLoading) {
				if (index != state.selectedBoardIndex) {
					postSideEffect(
						HomeSideEffect.GetArticles(
							state.boards?.get(index)?.address ?: ""
						)
					)
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
					state.selectedBoardIndex?.let { state.boards?.get(it)?.address } ?: "",
					id
				)
			)
		}
	}
}
