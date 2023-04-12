package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.rank.model.Rank
import com.devjj.platform.nurbanhoney.domain.rank.model.RankPreview

interface RankRepository {
    fun getRanks(): Result<List<Rank>>
    fun getTopRanks(
        offset: Int,
        limit: Int
    ): Result<List<RankPreview>>
}
