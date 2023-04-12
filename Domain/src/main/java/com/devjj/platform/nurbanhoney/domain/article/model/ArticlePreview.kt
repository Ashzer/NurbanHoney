package com.devjj.platform.nurbanhoney.domain.article.model

import com.devjj.platform.nurbanhoney.domain.board.model.Board

data class ArticlePreview(
    val id: Int,
    val thumbnail: String,
    val title: String,
    val replies: Int,
    val board: Board,
    val badge: String,
    val author: String,
    val likeCount: Int,
    val createdAt: String
    // val medals: String
    // val medals : List<String>
)
