package com.devjj.platform.nurbanhoney.domain.login

import com.devjj.platform.nurbanhoney.domain.LoginRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.login.model.NurbanTokenEntity
import javax.inject.Inject

class LoginRequestUseCase
@Inject constructor(
    private val loginRepository: LoginRepository
) : UseCase<NurbanTokenEntity, LoginRequestUseCase.Params>() {
    override suspend fun run(params: Params) = loginRepository.getNurbanToken(params.type, params.kakaoKey)
    data class Params(val type: String, val kakaoKey: String)
}
