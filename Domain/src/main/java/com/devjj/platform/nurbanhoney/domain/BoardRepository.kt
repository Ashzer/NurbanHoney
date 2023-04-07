package com.devjj.platform.nurbanhoney.domain

interface BoardRepository {
    fun getBoards(): Result<List<BoardEntity>>
}
