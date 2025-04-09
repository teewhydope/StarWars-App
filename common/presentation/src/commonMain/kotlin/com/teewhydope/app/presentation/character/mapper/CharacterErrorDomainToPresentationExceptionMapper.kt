package com.teewhydope.app.presentation.character.mapper

import com.teewhydope.app.domain.character.model.exception.NoInternetDomainException
import com.teewhydope.app.domain.character.model.exception.RequestTimeoutDomainException
import com.teewhydope.app.domain.common.model.exception.DomainException
import com.teewhydope.app.presentation.character.model.CharacterErrorPresentationModel
import com.teewhydope.app.presentation.character.model.CharacterErrorPresentationModel.*
import com.teewhydope.app.presentation.common.mapper.DomainToPresentationMapper


class CharacterErrorDomainToPresentationExceptionMapper :
    DomainToPresentationMapper<DomainException, CharacterErrorPresentationModel>() {
    override fun map(input: DomainException) =
        when (input) {
            is RequestTimeoutDomainException -> RequestTimeout
            is NoInternetDomainException -> NoInternet
            else -> Unknown
        }
}