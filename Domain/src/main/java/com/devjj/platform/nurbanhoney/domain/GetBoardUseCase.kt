package com.devjj.platform.nurbanhoney.domain

import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class GetBoardUseCase
@Inject constructor(
    private val repository: BoardRepository
) : UseCase<List<BoardEntity>, UseCase.None>() {
    override suspend fun run(params: None) = repository.getBoards()
}
