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
import javax.inject.Inject

@HiltViewModel
class BoardViewModel
@Inject constructor(
    private val getBoardUseCase: GetBoardUseCase,
    private val getArticlesUseCase: GetArticlesUseCase
) : ViewModel() {

    private var _boardsState = MutableStateFlow<List<Board>>(listOf())
    val boardsState: StateFlow<List<Board>> = _boardsState

    private val _articlesState = MutableStateFlow<List<ArticlePreview>>(listOf())
    val articlesState: StateFlow<List<ArticlePreview>> = _articlesState
    fun getBoards() {
        getBoardUseCase(UseCase.None(), viewModelScope) {
            it.fold(
                ::handleBoards,
                ::handleFailure
            )
        }
    }

    fun getArticle() {
        getArticlesUseCase(GetArticlesUseCase.Params("nurban", 0, 0, 10), viewModelScope) {
            it.fold(
                ::handleArticles,
                ::handleFailure
            )
        }
    }

    private fun handleArticles(articlePreviews: List<ArticlePreview>) {
        Log.d("handleArticle", articlePreviews.toString())
        _articlesState.value = articlePreviews
    }

    private fun handleBoards(boards: List<Board>) {
        boards.forEach {
            Log.d("handleBoards1", it.toString())
        }

        _boardsState.value = boards
        Log.d("handleBoards2", boardsState.value.toString())
    }

    private fun handleFailure(failure: Throwable) {
        Log.d("handleFailure", failure.toString())
    }
}

data class MainState(
    val boards: List<Board> = listOf()
    // val articles : List<Article> = listOf()
)

sealed class MainSideEffect {
    data class ShowToast(val message: String) : MainSideEffect()
    data class GetBoards(val boards: List<Board>) : MainSideEffect()
}
