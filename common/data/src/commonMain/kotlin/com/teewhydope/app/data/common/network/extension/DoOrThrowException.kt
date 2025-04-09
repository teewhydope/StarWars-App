package com.teewhydope.app.data.common.network.extension

import com.teewhydope.app.data.common.model.exception.ErrorResponseApiException
import com.teewhydope.app.domain.common.exception.ErrorResponseDomainException
import com.teewhydope.app.domain.common.model.exception.NoInternetConnectionDomainException
import com.teewhydope.app.domain.common.model.exception.UnknownDomainException
import io.ktor.utils.io.errors.IOException

inline fun <RETURN_TYPE> doOrThrowException(
    execute: () -> RETURN_TYPE,
    noinline exceptionHandler: ((Throwable) -> Throwable)? = null
): RETURN_TYPE {
    try {
        return execute()
    } catch (exception: Throwable) {
        throw if (exceptionHandler == null) {
            // Ktor client cannot catch offline exceptions
            // https://github.com/ktorio/ktor/issues/1165?ref=blog.karumi.com
            when (exception) {
                is IOException, is NoInternetConnectionDomainException -> {
                    NoInternetConnectionDomainException(exception)
                }

                is ErrorResponseApiException -> ErrorResponseDomainException(
                    exception,
                    exception.code
                )

                else -> UnknownDomainException(exception)
            }
        } else {
            exceptionHandler(exception)
        }
    }
}