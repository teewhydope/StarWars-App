package com.teewhydope.app.ui.character.mapper

import android.content.res.Resources
import androidx.annotation.StringRes
import com.teewhydope.app.presentation.character.model.CharacterErrorPresentationModel
import com.teewhydope.app.presentation.character.viewmodel.PeopleListViewState
import com.teewhydope.app.starwars.android.R

class PeopleListErrorPresentationToUiExceptionMapper(private val resources: Resources) {
    fun toUi(presentationError: PeopleListViewState.Error) = when (presentationError.error) {
        CharacterErrorPresentationModel.NoInternet -> string(R.string.no_internet_error)
        CharacterErrorPresentationModel.RequestTimeout -> string(R.string.people_list_error_timeout_description)
        CharacterErrorPresentationModel.Unknown -> string(R.string.people_list_error_unknown_description)
    }

    private fun string(@StringRes stringResourceId: Int) = resources.getString(stringResourceId)
}
