package com.devjj.platform.nurbanhoney.network

import com.devjj.platform.nurbanhoney.errorhandler.Failure
import retrofit2.Call

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
                403 -> Result.failure(Failure.TokenFailure)
                else -> Result.failure(Failure.ServerFailure)
            }
        }
    } catch (exception: Throwable) {
        Result.failure(Failure.NetworkFailure)
    }
}
