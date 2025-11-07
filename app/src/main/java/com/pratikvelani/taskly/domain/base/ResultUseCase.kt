package com.pratikvelani.taskly.domain.base

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

abstract class ResultUseCase<P, R> {

    operator fun invoke(params: P): Flow<R> = flow {
        emit(doWork(params))
    }

    protected abstract suspend fun doWork(params: P): R
}