package com.devjj.platform.nurbanhoney.domain.board

import com.devjj.platform.nurbanhoney.domain.BoardRepository
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.domain.interactor.UseCase
import javax.inject.Inject

class GetBoardUseCase
@Inject constructor(
    private val repository: BoardRepository
) : UseCase<List<Board>, UseCase.None>() {
    override suspend fun run(params: None) = repository.getBoards()
}
