package com.devjj.platform.nurbanhoney.network.api

import com.devjj.platform.nurbanhoney.network.entities.RankNetworkResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

internal interface RankApi {
    companion object {
        private const val BASE_RANK = "/rank"
        private const val POPUP = "/popup"
    }

    @GET("$BASE_RANK")
    fun getRanks() : Call<List<RankNetworkResponse>>

    @GET("$BASE_RANK$POPUP")
    fun getRanksTopThree(
        @Query("offset") offset : Int,
        @Query("limit") limit : Int
    ) : Call<List<RankNetworkResponse>>
}