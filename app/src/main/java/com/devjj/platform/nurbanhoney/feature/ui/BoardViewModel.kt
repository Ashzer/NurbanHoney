package com.devjj.platform.nurbanhoney.feature.ui

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.devjj.platform.nurbanhoney.domain.BoardEntity
import com.devjj.platform.nurbanhoney.domain.BoardRepository
import com.devjj.platform.nurbanhoney.domain.GetBoardUseCase
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BoardViewModel
@Inject constructor(
    private val getBoardUseCase: GetBoardUseCase
) : ViewModel() {

    var boardsState = mutableStateListOf<Board>()


    fun getBoards() {
        getBoardUseCase(UseCase.None(), viewModelScope) {
            it.fold(
                ::handleBoards,
                ::handleFailure
            )
        }
    }

    private fun handleBoards(boards: List<BoardEntity>) {
        boards.forEach {
            Log.d("boards_check__", it.toString())
        }

        boardsState = boards.map { Board(it.id, it.name, it.address) }.toMutableStateList()
    }

    private fun handleFailure(failure: Throwable) {
        Log.d("boards_check__", failure.toString())
    }
}