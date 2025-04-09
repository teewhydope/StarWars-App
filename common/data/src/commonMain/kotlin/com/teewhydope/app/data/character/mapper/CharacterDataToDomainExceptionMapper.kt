package com.teewhydope.app.data.character.mapper

import com.teewhydope.app.data.character.model.exception.NoInternetDataException
import com.teewhydope.app.data.common.mapper.DataToDomainMapper
import com.teewhydope.app.domain.common.model.exception.DomainException
import com.teewhydope.app.domain.common.model.exception.NoInternetConnectionDomainException
import com.teewhydope.app.domain.common.model.exception.UnknownDomainException

class CharacterDataToDomainExceptionMapper : DataToDomainMapper<Throwable, DomainException>() {
    override fun map(input: Throwable): DomainException =
        when (input) {
            is NoInternetDataException -> NoInternetConnectionDomainException(input)
            else -> UnknownDomainException(input)
        }
}