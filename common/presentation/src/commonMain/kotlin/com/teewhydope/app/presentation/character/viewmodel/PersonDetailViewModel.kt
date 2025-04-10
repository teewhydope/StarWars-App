package com.teewhydope.app.presentation.character.viewmodel

import com.teewhydope.app.domain.character.usecase.GetPersonDetailUseCase
import com.teewhydope.app.domain.common.model.exception.DomainException
import com.teewhydope.app.presentation.character.mapper.CharacterErrorDomainToPresentationExceptionMapper
import com.teewhydope.app.presentation.character.mapper.PersonDetailDomainToPresentationModelMapper
import com.teewhydope.app.presentation.common.notification.PresentationNotification
import com.teewhydope.app.presentation.common.viewmodel.BaseViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class PersonDetailViewModel : BaseViewModel<PersonDetailViewState, PresentationNotification>(),
    KoinComponent {

    override fun initialState() = PersonDetailViewState.Unset


    private val getPersonDetailUseCase: GetPersonDetailUseCase by inject()
    private val personDetailDomainToPresentationModelMapper: PersonDetailDomainToPresentationModelMapper by inject()
    private val characterErrorDomainToPresentationExceptionMapper: CharacterErrorDomainToPresentationExceptionMapper by inject()


    fun fetchPersonDetail(id: Int) {
        updateState(PersonDetailViewState.Loading)
        getPersonDetailUseCase(
            value = id,
            onResult = { domainModel ->
                updateState {
                    PersonDetailViewState.Loaded(
                        personDetail = personDetailDomainToPresentationModelMapper.toPresentation(
                            domainModel
                        )
                    )
                }
            },
            onException = ::handleUseCaseError
        )
    }


    private fun handleUseCaseError(domainException: DomainException) {
        updateState(
            PersonDetailViewState.Error(
                characterErrorDomainToPresentationExceptionMapper.toPresentation(domainException)
            )
        )
    }
}

