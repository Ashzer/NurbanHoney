package com.devjj.platform.nurbanhoney.network.api

import com.devjj.platform.nurbanhoney.network.entities.AppVersionNetworkResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface VersionCheckApi {
    companion object {
        private const val APP_VERSION = "appversion"
    }

    @GET(APP_VERSION)
    fun appVersion(@Query("app") appName : String) : Call<AppVersionNetworkResponse>
}