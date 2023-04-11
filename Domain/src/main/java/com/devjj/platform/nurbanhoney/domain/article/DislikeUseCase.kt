package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.RatingResponseEntity
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class DislikeUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<RatingResponseEntity, DislikeUseCase.Params>() {
    override suspend fun run(params: Params) = repository.postDislike(params.board, params.token, params.id)

    data class Params(
        val board: String,
        val token: String,
        val id: Int
    )
}
