package com.teewhydope.app.domain.character.usecase

import com.teewhydope.app.domain.character.model.PersonDetailDomainModel
import com.teewhydope.app.domain.character.repository.CharacterRepository
import com.teewhydope.app.domain.common.usecase.BackgroundExecutingUseCase
import com.teewhydope.app.domain.common.usecase.BaseUseCase
import kotlinx.coroutines.CoroutineScope


interface GetPersonDetailUseCase :
    BaseUseCase<Int, PersonDetailDomainModel>

class GetPersonDetailUseCaseImpl(
    private val characterRepository: CharacterRepository
) : GetPersonDetailUseCase,
    BackgroundExecutingUseCase<Int, PersonDetailDomainModel>() {
    override suspend fun executeInBackground(
        request: Int,
        coroutineScope: CoroutineScope
    ): PersonDetailDomainModel = characterRepository.personDetail(request)
}