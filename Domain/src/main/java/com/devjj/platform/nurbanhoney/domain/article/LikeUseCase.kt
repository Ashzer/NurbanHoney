package com.devjj.platform.nurbanhoney.domain.article

import com.devjj.platform.nurbanhoney.domain.ArticleRepository
import com.devjj.platform.nurbanhoney.domain.article.model.RatingResponse
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class LikeUseCase
@Inject constructor(
    private val repository: ArticleRepository
) : UseCase<RatingResponse, LikeUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.postLike(params.board, params.token, params.id)

    data class Params(
        val board: String,
        val token: String,
        val id: Int
    )
}
