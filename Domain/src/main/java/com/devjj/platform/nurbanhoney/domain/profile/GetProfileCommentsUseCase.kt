package com.devjj.platform.nurbanhoney.domain.profile

import com.devjj.platform.nurbanhoney.domain.ProfileRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.profile.model.ProfileCommentEntity
import javax.inject.Inject

class GetProfileCommentsUseCase
@Inject constructor(
    private val repository: ProfileRepository
) : UseCase<List<ProfileCommentEntity>, GetProfileCommentsUseCase.Params>() {
    override suspend fun run(params: Params) =
        repository.getMyComments(params.token, params.offset, params.limit)

    data class Params(val token: String, val offset: Int, val limit: Int)
}
