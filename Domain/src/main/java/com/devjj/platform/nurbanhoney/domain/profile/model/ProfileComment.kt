package com.devjj.platform.nurbanhoney.domain.profile.model

import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.extension.DateTime

data class ProfileComment(
    val id: Int,
    val content: String,
    val articleId: Int,
    val createAt: DateTime,
    var board: Board,
    val title: String
)
