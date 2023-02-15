package com.devjj.platform.nurbanhoney.feature.ui

import androidx.lifecycle.ViewModel
import com.devjj.platform.nurbanhoney.domain.BoardRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BoardViewModel
@Inject constructor(
    private val boardRepository: BoardRepository
): ViewModel() {
    fun getBoards() = boardRepository.getBoards()
}