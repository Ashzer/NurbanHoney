package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.rank.model.RankEntity
import com.devjj.platform.nurbanhoney.domain.rank.model.RankSimpleEntity

interface RankRepository {
    fun getRanks(): Result<List<RankEntity>>
    fun getTopRanks(
        offset: Int,
        limit: Int
    ): Result<List<RankSimpleEntity>>
}