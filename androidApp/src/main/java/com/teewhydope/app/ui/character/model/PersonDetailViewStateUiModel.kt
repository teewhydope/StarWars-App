package com.teewhydope.app.ui.character.model


import android.os.Parcelable
import kotlinx.parcelize.Parcelize


@Parcelize
sealed interface PersonDetailViewStateUiModel : Parcelable {
    @Parcelize
    data object Loading : PersonDetailViewStateUiModel

    @Parcelize
    data object Loaded : PersonDetailViewStateUiModel

    @Parcelize
    data object Unset : PersonDetailViewStateUiModel

    @Parcelize
    data object Error : PersonDetailViewStateUiModel
}