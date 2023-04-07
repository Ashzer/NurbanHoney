package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.article.ArticleItemEntity
import org.devjj.platform.nurbanhoney.features.ui.article.model.*

interface ArticleRepository {
    fun getArticle(board: String, token: String, id: Int): Result<ArticleEntity>
    fun postLike(board: String, token: String, id: Int): Result<RatingResponseEntity>
    fun cancelLike(board: String, token: String, id: Int): Result<RatingResponseEntity>
    fun postDislike(board: String, token: String, id: Int): Result<RatingResponseEntity>
    fun cancelDislike(board: String, token: String, id: Int): Result<RatingResponseEntity>
    fun getRatings(board: String, token: String, articleId: Int): Result<RatingsEntity>
    fun postComment(
        board: String,
        token: String,
        comment: String,
        id: Int
    ): Result<CommentResponseEntity>

    fun getComments(
        board: String,
        articleId: Int,
        offset: Int,
        limit: Int
    ): Result<List<CommentEntity>>

    fun deleteComment(
        board: String,
        token: String,
        id: Int,
        articleId: Int
    ): Result<CommentResponseEntity>

    fun updateComment(
        board: String,
        token: String,
        id: Int,
        comment: String
    ): Result<CommentResponseEntity>

    fun getComment(board: String, commentId: Int): Result<CommentEntity>

    fun getArticles(
        board: String,
        flag: Int,
        offset: Int,
        limit: Int
    ): Result<List<ArticleItemEntity>>
}