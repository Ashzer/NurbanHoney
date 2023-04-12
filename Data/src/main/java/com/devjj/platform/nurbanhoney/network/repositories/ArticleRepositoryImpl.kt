package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.*
import com.devjj.platform.nurbanhoney.domain.article.model.ArticlePreview
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.entities.ArticleEntity
import com.devjj.platform.nurbanhoney.network.entities.CommentEntity
import com.devjj.platform.nurbanhoney.network.entities.RatingsEntity
import com.devjj.platform.nurbanhoney.network.entities.SimpleResponseEntity
import com.devjj.platform.nurbanhoney.network.request
import com.devjj.platform.nurbanhoney.network.service.ArticleService
import javax.inject.Inject

class ArticleRepositoryImpl
@Inject constructor(
    private val networkHandler: NetworkHandler,
    private val articleService: ArticleService
) : ArticleRepository {

    override fun getArticles(
        board: String,
        flag: Int,
        offset: Int,
        limit: Int
    ): Result<List<ArticlePreview>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.getArticles(
                    board,
                    flag,
                    offset,
                    limit
                ),
                {
                    it.map { ArticlesRequestNetworkResponse ->
                        ArticlesRequestNetworkResponse.toNurbanHoneyArticle()
                    }
                },
                emptyList()
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun getArticle(
        board: String,
        token: String,
        id: Int
    ): Result<Article> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.getArticle(board, token, id),
                { it.toArticle() },
                ArticleEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun postLike(
        board: String,
        token: String,
        id: Int
    ): Result<RatingResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.postLike(board, token, id),
                { it.toRatingResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun cancelLike(
        board: String,
        token: String,
        id: Int
    ): Result<RatingResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.cancelLike(board, token, id),
                { it.toRatingResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun postDislike(
        board: String,
        token: String,
        id: Int
    ): Result<RatingResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.postDislike(
                    board,
                    token,
                    id
                ),
                { it.toRatingResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun cancelDislike(
        board: String,
        token: String,
        id: Int
    ): Result<RatingResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.cancelDislike(
                    board,
                    token,
                    id
                ),
                { it.toRatingResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun getRatings(
        board: String,
        token: String,
        articleId: Int
    ): Result<Ratings> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.getRatings(
                    board,
                    token,
                    articleId
                ),
                { it.toRatings() },
                RatingsEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun postComment(
        board: String,
        token: String,
        comment: String,
        id: Int
    ): Result<CommentResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.postComment(
                    board,
                    token,
                    comment,
                    id
                ),
                { it.toCommentResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun getComments(
        board: String,
        articleId: Int,
        offset: Int,
        limit: Int
    ): Result<List<Comment>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.getComments(
                    board,
                    articleId,
                    offset,
                    limit
                ),
                { it.map { CommentEntity -> CommentEntity.toComment() } },
                emptyList()
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun getComment(
        board: String,
        commentId: Int
    ): Result<Comment> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.getComment(board, commentId),
                { it.toComment() },
                CommentEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun deleteComment(
        board: String,
        token: String,
        id: Int,
        articleId: Int
    ): Result<CommentResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.deleteComment(
                    board,
                    token,
                    id,
                    articleId
                ),
                { it.toCommentResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun updateComment(
        board: String,
        token: String,
        id: Int,
        comment: String
    ): Result<CommentResponse> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                articleService.updateComment(
                    board,
                    token,
                    id,
                    comment
                ),
                { it.toCommentResponse() },
                SimpleResponseEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }
}
