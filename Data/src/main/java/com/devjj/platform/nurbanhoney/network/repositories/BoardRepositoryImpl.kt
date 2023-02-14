package com.devjj.platform.nurbanhoney.network.repositories

import com.devjj.platform.nurbanhoney.domain.BoardEntity
import com.devjj.platform.nurbanhoney.domain.BoardRepository
import com.devjj.platform.nurbanhoney.errorhandler.Failure
import com.devjj.platform.nurbanhoney.network.NetworkHandler
import com.devjj.platform.nurbanhoney.network.service.BoardService
import retrofit2.Call
import javax.inject.Inject

class BoardRepositoryImpl
@Inject constructor(
    private val boardService: BoardService,
    private val networkHandler: NetworkHandler
) : BoardRepository {
    override fun getBoards(): Result<List<BoardEntity>> {
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

fun <T, R> request(
    call: Call<T>,
    transform: (T) -> R,
    default: T
): Result<R> {
    return try {
        val response = call.execute()
        when (response.isSuccessful) {
            true -> Result.success(transform((response.body() ?: default)))
            false -> when (response.code()) {
                401 -> Result.failure(Failure.TokenFailure)
                else -> Result.failure(Failure.ServerFailure)
            }
        }
    } catch (exception: Throwable) {
        Result.failure(Failure.NetworkFailure)
    }
}