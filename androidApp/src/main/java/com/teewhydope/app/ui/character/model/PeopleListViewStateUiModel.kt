package com.teewhydope.app.ui.character.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
sealed interface PeopleListViewStateUiModel : Parcelable {
    @Parcelize
    data object Loading : PeopleListViewStateUiModel

    @Parcelize
    data object Loaded : PeopleListViewStateUiModel

    @Parcelize
    data object Unset : PeopleListViewStateUiModel

    @Parcelize
    data object Error : PeopleListViewStateUiModel
}
