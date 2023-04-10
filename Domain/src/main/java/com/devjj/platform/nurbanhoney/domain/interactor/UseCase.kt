package com.devjj.platform.nurbanhoney.domain.interactor

import kotlinx.coroutines.*

abstract class UseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Result<Type>

    @OptIn(DelicateCoroutinesApi::class)
    operator fun invoke(
        params: Params,
        scope: CoroutineScope = GlobalScope,
        onResult: (Result<Type>) -> Unit = {}
    ) {
        scope.launch(Dispatchers.Main) {
            val deferred = async(Dispatchers.IO) {
                run(params)
            }
            onResult(deferred.await())
        }
    }

    class None
}
