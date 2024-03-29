package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.Ratings
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class GetRatingsUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<Ratings, GetRatingsUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.getRatings(params.board, params.token, params.articleId)

    data class Params(
        val board: String,
        val token: String,
        val articleId: Int
    )
}
