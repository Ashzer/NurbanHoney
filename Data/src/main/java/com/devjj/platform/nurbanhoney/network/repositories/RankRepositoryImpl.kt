package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.RankRepository
import com.devjj.platform.nurbanhoney.domain.rank.model.Rank
import com.devjj.platform.nurbanhoney.domain.rank.model.RankPreview
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.request
import com.devjj.platform.nurbanhoney.network.service.RankService
import javax.inject.Inject

class RankRepositoryImpl
@Inject constructor(
    private val networkHandler: NetworkHandler,
    private val rankService: RankService
) : RankRepository {
    override fun getRanks(): Result<List<Rank>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                rankService.getRanks(),
                { it.map { RankEntity -> RankEntity.toRank() } },
                listOf()
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }

    override fun getTopRanks(
        offset: Int,
        limit: Int
    ): Result<List<RankPreview>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                rankService.getRanksTopThree(offset, limit),
                { it.map { RankEntity -> RankEntity.toRankSimple() } },
                listOf()
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }
}
