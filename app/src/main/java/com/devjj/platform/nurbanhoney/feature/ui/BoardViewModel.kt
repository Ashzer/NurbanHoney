package com.devjj.platform.nurbanhoney.feature.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjj.platform.nurbanhoney.domain.article.GetArticlesUseCase
import com.devjj.platform.nurbanhoney.domain.article.model.ArticleItemEntity
import com.devjj.platform.nurbanhoney.domain.board.GetBoardUseCase
import com.devjj.platform.nurbanhoney.domain.board.model.BoardEntity
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

    private var _boardsState = MutableStateFlow<List<BoardEntity>>(listOf())
    val boardsState: StateFlow<List<BoardEntity>> = _boardsState

    private val _articlesState = MutableStateFlow<List<ArticleItemEntity>>(listOf())
    val articlesState: StateFlow<List<ArticleItemEntity>> = _articlesState
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

    private fun handleArticles(articles: List<ArticleItemEntity>) {
        Log.d("handleArticle", articles.toString())
        _articlesState.value = articles
    }

    private fun handleBoards(boards: List<BoardEntity>) {
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
    val boards: List<BoardEntity> = listOf()
    // val articles : List<Article> = listOf()
)

sealed class MainSideEffect {
    data class ShowToast(val message: String) : MainSideEffect()
    data class GetBoards(val boards: List<BoardEntity>) : MainSideEffect()
}
