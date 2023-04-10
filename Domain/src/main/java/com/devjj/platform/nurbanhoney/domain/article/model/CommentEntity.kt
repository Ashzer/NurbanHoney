package com.devjj.platform.nurbanhoney.domain.article.model

import com.devjj.platform.nurbanhoney.extension.empty

data class CommentEntity(
    val id: Int,
    val comment: String,
    val articleId: Int,
    val userId: Int,
    val badge: String,
    val nickname: String,
    val insignia: List<String>
) {
    companion object {
        val empty = CommentEntity(0, String.empty(), 0, 0, String.empty(), String.empty(), listOf())
    }
}
