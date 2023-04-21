package com.devjj.platform.nurbanhoney.domain.interactor

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Result<Type>

    suspend operator fun invoke(
        params: Params,
        onResult: (Result<Type>) -> Unit = {}
    ) {
        onResult(run(params))
    }

    class None
}
