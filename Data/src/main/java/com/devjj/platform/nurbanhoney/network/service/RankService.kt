package com.devjj.platform.nurbanhoney.network.service

import com.devjj.platform.nurbanhoney.network.api.RankApi
import retrofit2.Retrofit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RankService
@Inject constructor(retrofit: Retrofit) : RankApi {
    private val rankApi by lazy { retrofit.create(RankApi::class.java) }

    override fun getRanks() = rankApi.getRanks()
    override fun getRanksTopThree(offset: Int, limit: Int) =
        rankApi.getRanksTopThree(offset, limit)
}
