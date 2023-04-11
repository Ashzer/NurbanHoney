package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.CommentResponseEntity
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class UpdateCommentUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<CommentResponseEntity, UpdateCommentUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.updateComment(params.board, params.token, params.id, params.comment)

    data class Params(
        val board: String,
        val token: String,
        val id: Int,
        val comment: String
    )
}
