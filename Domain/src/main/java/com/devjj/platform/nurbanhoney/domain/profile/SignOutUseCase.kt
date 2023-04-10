package com.devjj.platform.nurbanhoney.domain.profile

import com.devjj.platform.nurbanhoney.domain.ProfileRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.profile.model.SignOutResponseEntity
import javax.inject.Inject

class SignOutUseCase
@Inject constructor(
    private val repository: ProfileRepository
) : UseCase<SignOutResponseEntity, SignOutUseCase.Params>() {
    override suspend fun run(params: Params) = repository.signOut(params.token, params.id)

    data class Params(val token: String, val id: Int)
}