package com.devjj.platform.nurbanhoney.domain.profile.model

import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.extension.DateTime
import com.devjj.platform.nurbanhoney.extension.empty

data class ProfileArticle(
    val id: Int,
    var board: Board,
    val thumbnail: String,
    val title: String,
    val commentCount: Int,
    val createAt: DateTime
) {
    companion object {
        val empty =
            ProfileArticle(0, Board.empty, String.empty(), String.empty(), 0, DateTime.now)
    }
}
