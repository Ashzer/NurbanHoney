package com.devjj.platform.nurbanhoney.feature.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjj.platform.nurbanhoney.domain.article.GetArticlesUseCase
import com.devjj.platform.nurbanhoney.domain.article.model.ArticlePreview
import com.devjj.platform.nurbanhoney.domain.board.GetBoardUseCase
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.syntax.simple.intent
import org.orbitmvi.orbit.syntax.simple.reduce
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

@HiltViewModel
class BoardViewModel
@Inject constructor(
	private val getBoardUseCase: GetBoardUseCase,
	private val getArticlesUseCase: GetArticlesUseCase,
) : ViewModel(), ContainerHost<MainState, MainSideEffect> {

	private var _boardsState =
		MutableStateFlow<List<Board>>(listOf())
	val boardsState: StateFlow<List<Board>> = _boardsState
	override val container =
		container<MainState, MainSideEffect>(MainState())

	private val _articlesState =
		MutableStateFlow<List<ArticlePreview>>(listOf())
	val articlesState: StateFlow<List<ArticlePreview>> =
		_articlesState

	fun getBoards() {
		intent {
			viewModelScope.launch {
				reduce { state.copy(state = UiState.Loading) }
				getBoardUseCase(UseCase.None()) { resultBoards ->
					resultBoards.fold(
						::handleBoards,
						::handleFailure
					)
				}
			}
		}
	}

	fun getArticle() {
//        getArticlesUseCase(GetArticlesUseCase.Params("nurban", 0, 0, 10), viewModelScope) {
//            it.fold(
//                ::handleArticles,
//                ::handleFailure
//            )
//        }
	}

	private fun handleArticles(articlePreviews: List<ArticlePreview>) {
		Log.d("handleArticle", articlePreviews.toString())
		_articlesState.value = articlePreviews
	}

	private fun handleBoards(boards: List<Board>) = intent {
		reduce {
			state.copy(
				state = UiState.Success,
				boards = boards
			)
		}

//		_boardsState.value = boards
		//Log.d("handleBoards2", boardsState.value.toString())
	}

	private fun handleFailure(failure: Throwable) = intent {
		reduce{
			state.copy(state = UiState.Failed("Error"))
		}
	}
}

data class MainState(
	val state: UiState = UiState.Loading,
	val boards: List<Board>? = null
)

sealed class MainSideEffect {
	data class ShowToast(val message: String) :
		MainSideEffect()

	data class GetBoards(val boards: List<Board>) :
		MainSideEffect()
}

sealed class UiState {
	object Loading : UiState()
	object Success : UiState()
	data class Failed(val message: String) : UiState()
}