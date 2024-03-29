package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.CommentResponse
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class PostCommentUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<CommentResponse, PostCommentUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.postComment(params.board, params.token, params.comment, params.id)

    data class Params(
        val board: String,
        val token: String,
        val comment: String,
        val id: Int
    )
}
