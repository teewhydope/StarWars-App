package com.teewhydope.app.domain.character.model.exception

import com.teewhydope.app.domain.common.model.exception.DomainException


class RequestTimeoutDomainException(throwable: Throwable) : DomainException(throwable)
