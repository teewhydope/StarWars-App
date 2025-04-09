package com.teewhydope.app.domain.character.usecase

import com.teewhydope.app.domain.common.usecase.BackgroundExecutingUseCase
import com.teewhydope.app.domain.common.usecase.BaseUseCase
import com.teewhydope.app.domain.character.model.PeopleDomainModel
import com.teewhydope.app.domain.character.repository.CharacterRepository
import kotlinx.coroutines.CoroutineScope

interface GetPeopleUseCase :
    BaseUseCase<Unit, PeopleDomainModel>

class GetPeopleUseCaseImpl(
    private val characterRepository: CharacterRepository
) : GetPeopleUseCase,
    BackgroundExecutingUseCase<Unit, PeopleDomainModel>() {
    override suspend fun executeInBackground(
        request: Unit,
        coroutineScope: CoroutineScope
    ): PeopleDomainModel = characterRepository.people()
}