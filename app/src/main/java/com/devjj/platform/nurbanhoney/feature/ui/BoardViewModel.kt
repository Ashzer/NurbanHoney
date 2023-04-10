package com.devjj.platform.nurbanhoney.feature.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjj.platform.nurbanhoney.domain.article.GetArticleUseCase
import com.devjj.platform.nurbanhoney.domain.article.GetArticlesUseCase
import com.devjj.platform.nurbanhoney.domain.article.model.ArticleEntity
import com.devjj.platform.nurbanhoney.domain.article.model.ArticleItemEntity
import com.devjj.platform.nurbanhoney.domain.board.model.BoardEntity
import com.devjj.platform.nurbanhoney.domain.board.GetBoardUseCase
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class BoardViewModel
@Inject constructor(
    private val getBoardUseCase: GetBoardUseCase,
    private val getArticlesUseCase : GetArticlesUseCase
) : ViewModel() {

    private var _boardsState = MutableStateFlow<List<Board>>(listOf())
    val boardsState: StateFlow<List<Board>> = _boardsState

    fun getBoards() {
        getBoardUseCase(UseCase.None(), viewModelScope) {
            it.fold(
                ::handleBoards,
                ::handleFailure
            )
        }
    }


    fun getArticle(){
        getArticlesUseCase(GetArticlesUseCase.Params("free",0,0,10), viewModelScope) {
            it.fold(
                ::handleArticles,
                ::handleFailure
            )
        }
    }

    private fun handleArticles(article : List<ArticleItemEntity>){
        Log.d("handleArticle", article.toString())
    }

    private fun handleBoards(boards: List<BoardEntity>) {
        boards.forEach {
            Log.d("handleBoards1", it.toString())
        }

        _boardsState.value = boards.map { Board(it.id, it.name, it.address) }.toList()
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
