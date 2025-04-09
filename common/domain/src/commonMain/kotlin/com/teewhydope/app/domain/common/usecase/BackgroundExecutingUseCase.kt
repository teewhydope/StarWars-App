package com.teewhydope.app.domain.common.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

abstract class BackgroundExecutingUseCase<REQUEST, RESULT> : BaseUseCase<REQUEST, RESULT> {
    final override suspend fun execute(input: REQUEST, onResult: (RESULT) -> Unit) {
        val result = withContext(Dispatchers.IO) {
            executeInBackground(input, this)
        }
        onResult(result)
    }

    abstract suspend fun executeInBackground(
        request: REQUEST,
        coroutineScope: CoroutineScope
    ): RESULT
}