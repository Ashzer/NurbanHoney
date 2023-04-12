package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.article.model.*
import com.devjj.platform.nurbanhoney.domain.article.model.ArticlePreview

interface ArticleRepository {
    fun getArticle(board: String, token: String, id: Int): Result<Article>
    fun postLike(board: String, token: String, id: Int): Result<RatingResponse>
    fun cancelLike(board: String, token: String, id: Int): Result<RatingResponse>
    fun postDislike(board: String, token: String, id: Int): Result<RatingResponse>
    fun cancelDislike(board: String, token: String, id: Int): Result<RatingResponse>
    fun getRatings(board: String, token: String, articleId: Int): Result<Ratings>
    fun postComment(
        board: String,
        token: String,
        comment: String,
        id: Int
    ): Result<CommentResponse>

    fun getComments(
        board: String,
        articleId: Int,
        offset: Int,
        limit: Int
    ): Result<List<Comment>>

    fun deleteComment(
        board: String,
        token: String,
        id: Int,
        articleId: Int
    ): Result<CommentResponse>

    fun updateComment(
        board: String,
        token: String,
        id: Int,
        comment: String
    ): Result<CommentResponse>

    fun getComment(board: String, commentId: Int): Result<Comment>

    fun getArticles(
        board: String,
        flag: Int,
        offset: Int,
        limit: Int
    ): Result<List<ArticlePreview>>
}
