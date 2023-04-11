package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.CommentEntity
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class GetCommentUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<CommentEntity, GetCommentUseCase.Params>() {
    override suspend fun run(params: Params) = repository.getComment(params.board, params.commentId)

    data class Params(val board: String, val commentId: Int)
}
