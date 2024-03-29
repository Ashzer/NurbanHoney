package com.devjj.platform.nurbanhoney.network.service

import com.devjj.platform.nurbanhoney.network.api.LoginApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class LoginService
@Inject constructor(retrofit: Retrofit) : LoginApi {
    private val loginApi by lazy { retrofit.create(LoginApi::class.java) }

    override fun loginRequest(type: String, key: String) =
        loginApi.loginRequest(type, key)

    override fun validationCheck(token: String) =
        loginApi.validationCheck(token)
}
