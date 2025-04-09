package com.teewhydope.app.ui.character.mapper

import com.teewhydope.app.common.mapper.PresentationToUiMapper
import com.teewhydope.app.presentation.character.viewmodel.PeopleListViewState
import com.teewhydope.app.ui.character.model.PeopleListViewStateUiModel


class PeopleListViewStatePresentationToUiMapper :
    PresentationToUiMapper<PeopleListViewState, PeopleListViewStateUiModel>() {
    override fun map(input: PeopleListViewState) =
        when (input) {
            is PeopleListViewState.Loading -> PeopleListViewStateUiModel.Loading
            is PeopleListViewState.Loaded -> PeopleListViewStateUiModel.Loaded
            is PeopleListViewState.Unset -> PeopleListViewStateUiModel.Unset
            is PeopleListViewState.Error -> PeopleListViewStateUiModel.Error
        }
}
