package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.board.model.Board

interface BoardRepository {
    fun getBoards(): Result<List<Board>>
}
