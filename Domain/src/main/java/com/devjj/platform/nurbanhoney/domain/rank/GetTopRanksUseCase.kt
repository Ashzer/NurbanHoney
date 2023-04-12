package com.devjj.platform.nurbanhoney.domain.rank

import com.devjj.platform.nurbanhoney.domain.RankRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.rank.model.RankPreview
import javax.inject.Inject

class GetTopRanksUseCase
@Inject constructor(
    private val repository: RankRepository
) : UseCase<List<RankPreview>, GetTopRanksUseCase.Params>() {

    override suspend fun run(params: Params) = repository.getTopRanks(params.offset, params.limit)

    data class Params(
        val offset: Int,
        val limit: Int
    )
}
