package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.board.model.BoardEntity

interface BoardRepository {
    fun getBoards(): Result<List<BoardEntity>>
}
