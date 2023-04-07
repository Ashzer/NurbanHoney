package com.devjj.platform.nurbanhoney.network.api

import com.devjj.platform.nurbanhoney.network.entities.LoginNetworkResponse
import com.devjj.platform.nurbanhoney.network.entities.ValidationNetworkResponse
import retrofit2.Call
import retrofit2.http.*

internal interface LoginApi {
    companion object {
        private const val LOGIN = "login"
        private const val VALIDATION = "token/exam"
    }

    @FormUrlEncoded
    @POST(LOGIN)
    fun loginRequest(
        @Field("loginType") type: String,
        @Field("key") key: String
    ): Call<LoginNetworkResponse>

    @GET(VALIDATION)
    fun validationCheck(@Header("token") token: String): Call<ValidationNetworkResponse>
}