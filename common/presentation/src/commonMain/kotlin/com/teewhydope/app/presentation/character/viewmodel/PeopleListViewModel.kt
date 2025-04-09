package com.teewhydope.app.presentation.character.viewmodel

import com.teewhydope.app.domain.character.usecase.GetPeopleUseCase
import com.teewhydope.app.domain.common.model.exception.DomainException
import com.teewhydope.app.presentation.character.mapper.CharacterErrorDomainToPresentationExceptionMapper
import com.teewhydope.app.presentation.character.mapper.PeopleDomainToPresentationModelMapper
import com.teewhydope.app.presentation.character.model.PeopleListPresentationNavigationEvent.OnViewDetails
import com.teewhydope.app.presentation.common.notification.PresentationNotification
import com.teewhydope.app.presentation.common.viewmodel.BaseViewModel
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject


class PeopleListViewModel : BaseViewModel<PeopleListViewState, PresentationNotification>(),
    KoinComponent {

    override fun initialState() = PeopleListViewState.Unset

    private val getPeopleUseCase: GetPeopleUseCase by inject()
    private val peopleDomainToPresentationModelMapper: PeopleDomainToPresentationModelMapper by inject()
    private val characterErrorDomainToPresentationExceptionMapper: CharacterErrorDomainToPresentationExceptionMapper by inject()


    fun fetchPeople() {
        updateState(PeopleListViewState.Loading)
        getPeopleUseCase(
            onResult = { domainModel ->
                updateState {
                    PeopleListViewState.Loaded(
                        people = peopleDomainToPresentationModelMapper.toPresentation(
                            domainModel
                        )
                    )
                }
            },
            onException = ::handleUseCaseError
        )
    }

    fun onViewDetailsAction(id: Int) {
        navigate(OnViewDetails(id))
    }


    private fun handleUseCaseError(domainException: DomainException) {
        updateState(
            PeopleListViewState.Error(
                characterErrorDomainToPresentationExceptionMapper.toPresentation(domainException)
            )
        )
    }
}


