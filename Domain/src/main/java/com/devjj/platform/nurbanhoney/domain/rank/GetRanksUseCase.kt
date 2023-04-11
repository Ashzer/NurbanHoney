package com.devjj.platform.nurbanhoney.domain.rank

import com.devjj.platform.nurbanhoney.domain.RankRepository
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import com.devjj.platform.nurbanhoney.domain.rank.model.RankEntity
import javax.inject.Inject

class GetRanksUseCase
@Inject constructor(
    private val repository: RankRepository
) : UseCase<List<RankEntity>, UseCase.None>() {
    override suspend fun run(params: None) = repository.getRanks()
}
