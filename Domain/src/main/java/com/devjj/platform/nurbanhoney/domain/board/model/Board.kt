package com.devjj.platform.nurbanhoney.domain.board.model

data class Board(
    val id: Int,
    val name: String,
    val address: String
) {
    companion object {
        val empty = Board(-1, "", "")
    }
}
