package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.BoardRepository
import com.devjj.platform.nurbanhoney.domain.board.model.Board
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.request
import com.devjj.platform.nurbanhoney.network.service.BoardService
import javax.inject.Inject

class BoardRepositoryImpl
@Inject constructor(
    private val boardService: BoardService,
    private val networkHandler: NetworkHandler
) : BoardRepository {
    override fun getBoards(): Result<List<Board>> {
        return when (networkHandler.isNetworkAvailable()) {
            true -> request(
                boardService.getBoards(),
                { it.map { BoardNetworkResponse -> BoardNetworkResponse.toBoardEntity() } },
                emptyList()
            )
            false -> Result.failure(Failure.NetworkFailure)
        }
    }
}
