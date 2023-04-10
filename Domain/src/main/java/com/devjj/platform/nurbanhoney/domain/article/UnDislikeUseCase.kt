package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.article.model.RatingResponseEntity
import javax.inject.Inject

class UnDislikeUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<RatingResponseEntity, UnDislikeUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.cancelDislike(params.board, params.token, params.id)

    data class Params(
        val board: String,
        val token: String,
        val id: Int
    )
}
