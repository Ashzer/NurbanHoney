package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.LoginRepository
import com.devjj.platform.nurbanhoney.domain.login.model.NurbanToken
import com.devjj.platform.nurbanhoney.domain.login.model.TokenStatus
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.entities.LoginInfoEntity
import com.devjj.platform.nurbanhoney.network.entities.ValidateInfoEntity
import com.devjj.platform.nurbanhoney.network.request
import com.devjj.platform.nurbanhoney.network.service.LoginService
import javax.inject.Inject

class LoginRepositoryImpl
@Inject constructor(
    private val networkHandler: NetworkHandler,
    private val loginService: LoginService
) : LoginRepository {

    override fun getNurbanToken(
        type: String,
        key: String
    ): Result<NurbanToken> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                loginService.loginRequest(
                    type,
                    key
                ),
                { it.toNurbanToken() },
                LoginInfoEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun isTokenValid(token: String): Result<TokenStatus> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                loginService.validationCheck(token),
                { it.toIsTokenValid() },
                ValidateInfoEntity.empty
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }
}
