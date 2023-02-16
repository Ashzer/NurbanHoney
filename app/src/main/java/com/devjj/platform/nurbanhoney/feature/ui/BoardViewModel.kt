package com.devjj.platform.nurbanhoney.feature.ui

import android.util.Log
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
    }

    private fun handleFailure(failure: Throwable) {
        Log.d("boards_check__", failure.toString())
    }
}