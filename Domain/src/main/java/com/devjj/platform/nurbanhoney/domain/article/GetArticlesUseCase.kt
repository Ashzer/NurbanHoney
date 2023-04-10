package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.ArticleItemEntity
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class GetArticlesUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<List<ArticleItemEntity>, GetArticlesUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.getArticles(params.board, params.flag, params.offset, params.limit)

    data class Params(val board: String, val flag: Int, val offset: Int, val limit: Int)
}
