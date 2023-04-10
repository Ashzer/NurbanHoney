package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.LoginRepository
import com.devjj.platform.nurbanhoney.domain.login.model.NurbanTokenEntity
import com.devjj.platform.nurbanhoney.domain.login.model.TokenStatusEntity
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.entities.LoginNetworkResponse
import com.devjj.platform.nurbanhoney.network.entities.ValidationNetworkResponse
import com.devjj.platform.nurbanhoney.network.request
import com.devjj.platform.nurbanhoney.network.service.LoginService
import javax.inject.Inject

class LoginRepositoryImpl
@Inject constructor(
	private val networkHandler: NetworkHandler,
	private val loginService: LoginService
) : LoginRepository {

	override fun getNurbanToken(
		type: String, kakaoKey: String
	): Result<NurbanTokenEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				loginService.loginRequest(
					type, kakaoKey
				),
				{ it.toNurbanToken() },
				LoginNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}

	override fun isTokenValid(token: String): Result<TokenStatusEntity> {
		return when (networkHandler.isNetworkAvailable()) {
			true -> request(
				loginService.validationCheck(token),
				{ it.toIsTokenValid() },
				ValidationNetworkResponse.empty
			)
			false -> Result.failure(Failure.NetworkFailure)
		}
	}
}