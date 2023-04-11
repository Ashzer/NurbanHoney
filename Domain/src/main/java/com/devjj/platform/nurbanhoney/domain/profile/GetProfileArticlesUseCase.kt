package com.devjj.platform.nurbanhoney.domain.profile

import com.devjj.platform.nurbanhoney.domain.ProfileRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.profile.model.ProfileArticleEntity
import javax.inject.Inject

class GetProfileArticlesUseCase
@Inject constructor(
    private val repository: ProfileRepository
) : UseCase<List<ProfileArticleEntity>, GetProfileArticlesUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.getMyArticles(params.token, params.offset, params.limit)

    data class Params(val token: String, val offset: Int, val limit: Int)
}
