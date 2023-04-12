package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.CommentResponse
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class DeleteCommentUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<CommentResponse, DeleteCommentUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.deleteComment(
            params.board,
            params.token,
            params.id,
            params.articleId
        )

    data class Params(
        val board: String,
        val token: String,
        val id: Int,
        val articleId: Int
    )
}
