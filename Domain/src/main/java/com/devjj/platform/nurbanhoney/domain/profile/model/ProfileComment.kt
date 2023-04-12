package com.devjj.platform.nurbanhoney.domain.profile.model

import com.devjj.platform.nurbanhoney.domain.board.model.Board
import org.threeten.bp.LocalDateTime

data class ProfileComment(
	val id: Int,
	val content: String,
	val articleId: Int,
	val createAt: LocalDateTime?,
	var board: Board,
	val title: String
)
