package com.devjj.platform.nurbanhoney.domain.login

import com.devjj.platform.nurbanhoney.domain.LoginRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.login.model.TokenStatusEntity
import javax.inject.Inject

class IsTokenValidUseCase
@Inject constructor(
    private val loginRepository: LoginRepository
) : UseCase<TokenStatusEntity, IsTokenValidUseCase.Params>() {
    override suspend fun run(params: Params) = loginRepository.isTokenValid(params.token)
    data class Params(val token : String)
}