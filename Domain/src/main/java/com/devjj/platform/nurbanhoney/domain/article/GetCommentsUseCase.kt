package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.Comment
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class GetCommentsUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<List<Comment>, GetCommentsUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.getComments(params.board, params.articleId, params.offset, params.limit)

    data class Params(val board: String, val articleId: Int, val offset: Int, val limit: Int)
}
