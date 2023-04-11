package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.RatingResponseEntity
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class UnLikeUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<RatingResponseEntity, UnLikeUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.cancelLike(params.board, params.token, params.id)

    data class Params(
        val board: String,
        val token: String,
        val id: Int
    )
}
