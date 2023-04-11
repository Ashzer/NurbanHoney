package com.devjj.platform.nurbanhoney.domain.profile

import com.devjj.platform.nurbanhoney.domain.ProfileRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.profile.model.ProfileEntity
import javax.inject.Inject

class GetProfileUseCase
@Inject constructor(
    private val repository: ProfileRepository
) : UseCase<ProfileEntity, GetProfileUseCase.Params>() {
    override suspend fun run(params: Params) = repository.getProfile(params.token)

    data class Params(val token: String)
}
