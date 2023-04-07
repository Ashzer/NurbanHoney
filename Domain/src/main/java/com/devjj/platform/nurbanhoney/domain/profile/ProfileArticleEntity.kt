package com.devjj.platform.nurbanhoney.domain.profile

import com.devjj.platform.nurbanhoney.domain.BoardEntity
import com.devjj.platform.nurbanhoney.extension.empty
import org.threeten.bp.LocalDateTime

data class ProfileArticleEntity(
    val id: Int,
    var board: BoardEntity,
    val thumbnail: String,
    val title: String,
    val commentCount: Int,
    val createAt: LocalDateTime?
) {
    companion object {
        val empty =
            ProfileArticleEntity(0, BoardEntity.empty, String.empty(), String.empty(), 0, null)
    }
}