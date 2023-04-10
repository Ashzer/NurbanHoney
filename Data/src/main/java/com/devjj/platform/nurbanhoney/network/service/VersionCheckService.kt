package com.devjj.platform.nurbanhoney.network.service

import com.devjj.platform.nurbanhoney.network.api.VersionCheckApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class VersionCheckService
@Inject constructor(retrofit: Retrofit) : VersionCheckApi {
    private val versionCheckApi by lazy { retrofit.create(VersionCheckApi::class.java) }

    override fun appVersion(appName: String) = versionCheckApi.appVersion(appName)
}
