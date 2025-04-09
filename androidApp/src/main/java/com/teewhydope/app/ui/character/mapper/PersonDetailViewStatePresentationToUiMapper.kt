package com.teewhydope.app.ui.character.mapper

import com.teewhydope.app.common.mapper.PresentationToUiMapper
import com.teewhydope.app.presentation.character.viewmodel.PersonDetailViewState
import com.teewhydope.app.ui.character.model.PersonDetailViewStateUiModel


class PersonDetailViewStatePresentationToUiMapper :
    PresentationToUiMapper<PersonDetailViewState, PersonDetailViewStateUiModel>() {
    override fun map(input: PersonDetailViewState) =
        when (input) {
            is PersonDetailViewState.Loading -> PersonDetailViewStateUiModel.Loading
            is PersonDetailViewState.Loaded -> PersonDetailViewStateUiModel.Loaded
            is PersonDetailViewState.Unset -> PersonDetailViewStateUiModel.Unset
            is PersonDetailViewState.Error -> PersonDetailViewStateUiModel.Error
        }
}