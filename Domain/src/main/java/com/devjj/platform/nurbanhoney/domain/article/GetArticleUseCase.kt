package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.ArticleEntity
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class GetArticleUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<ArticleEntity, GetArticleUseCase.Params>() {

    override suspend fun run(params: Params) =
        repository.getArticle(params.board, params.token, params.id)

    data class Params(val board: String, val token: String, val id: Int)
}
