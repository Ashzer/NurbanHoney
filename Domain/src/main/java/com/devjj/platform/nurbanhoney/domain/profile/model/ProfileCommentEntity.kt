package com.devjj.platform.nurbanhoney.domain.profile.model

import com.devjj.platform.nurbanhoney.domain.board.model.BoardEntity
import org.threeten.bp.LocalDateTime

data class ProfileCommentEntity(
	val id: Int,
	val content: String,
	val articleId: Int,
	val createAt: LocalDateTime?,
	var board: BoardEntity,
	val title: String
)
