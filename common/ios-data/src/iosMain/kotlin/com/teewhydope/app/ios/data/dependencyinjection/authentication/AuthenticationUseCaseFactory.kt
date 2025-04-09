package com.teewhydope.app.ios.data.dependencyinjection.authentication

import com.teewhydope.app.domain.character.repository.CharacterRepository
import com.teewhydope.app.domain.character.usecase.LoginWithEmailAndPasswordUseCase
import com.teewhydope.app.domain.character.usecase.LoginWithEmailAndPasswordUseCaseImpl

class AuthenticationUseCaseFactory(
    private val characterRepository: CharacterRepository,
) {

    val getLoginWithEmailAndPasswordUseCase: LoginWithEmailAndPasswordUseCase by lazy {
        LoginWithEmailAndPasswordUseCaseImpl(
            characterRepository = characterRepository,
        )
    }
}