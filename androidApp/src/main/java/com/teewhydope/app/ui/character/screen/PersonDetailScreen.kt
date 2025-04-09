package com.teewhydope.app.ui.character.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.teewhydope.app.common.navigation.mapper.NavigationEventDestinationMapper
import com.teewhydope.app.common.view.BaseComposeHolder
import com.teewhydope.app.common.view.ScreenEnterObserver
import com.teewhydope.app.common.widgets.AlertDialog
import com.teewhydope.app.common.widgets.LoadingContainer
import com.teewhydope.app.presentation.character.viewmodel.PersonDetailViewModel
import com.teewhydope.app.presentation.character.viewmodel.PersonDetailViewState
import com.teewhydope.app.presentation.common.navigation.PresentationNavigationEvent
import com.teewhydope.app.presentation.common.notification.PresentationNotification
import com.teewhydope.app.ui.character.mapper.PersonDetailErrorPresentationToUiExceptionMapper
import com.teewhydope.app.ui.character.mapper.PersonDetailPresentationToUiModelMapper
import com.teewhydope.app.ui.character.mapper.PersonDetailViewStatePresentationToUiMapper
import com.teewhydope.app.ui.character.model.PersonDetailUiModel
import com.teewhydope.app.ui.character.model.PersonDetailViewStateUiModel
import com.teewhydope.app.ui.character.model.PersonDetailViewStateUiModel.*
import com.teewhydope.app.ui.character.widget.ImageCard

data class PersonDetailDependencies(
    val viewModel: PersonDetailViewModel,
    val personDetailPresentationToUiModelMapper: PersonDetailPresentationToUiModelMapper,
    val personDetailViewStatePresentationToUiMapper: PersonDetailViewStatePresentationToUiMapper,
    private val personDetailNavigationMapper:
    NavigationEventDestinationMapper<PresentationNavigationEvent>,
    val personDetailErrorPresentationToUiExceptionMapper: PersonDetailErrorPresentationToUiExceptionMapper,
) : BaseComposeHolder<PersonDetailViewState, PresentationNotification>(
    viewModel,
    personDetailNavigationMapper,
    null
)

@Composable
fun PersonDetailDependencies.PersonDetailScreen(
    id: Int?,
    navController: NavController
) {

    ScreenEnterObserver {
        if (id != null) {
            viewModel.fetchPersonDetail(id)
        }
    }

    ViewModelObserver(navController)

    val viewState by viewModel.viewState.collectAsState(PersonDetailViewState.Loading)

    val personDetailModel =
        (viewState as? PersonDetailViewState.Loaded)?.let(personDetailPresentationToUiModelMapper::toUi)


    val errorMessage = (viewState as? PersonDetailViewState.Error)
        ?.let(personDetailErrorPresentationToUiExceptionMapper::toUi).orEmpty()

    val uiState by rememberSaveable(viewState) {
        mutableStateOf(personDetailViewStatePresentationToUiMapper.toUi(viewState))
    }

    PersonDetailContent(
        viewState = uiState,
        personDetailUiModel = personDetailModel,
        errorMessage = errorMessage,
        onCloseDialog = {
            if (id != null) {
                viewModel.fetchPersonDetail(id)
            }
        },
    )
}


@Composable
fun PersonDetailContent(
    onCloseDialog: () -> Unit,
    personDetailUiModel: PersonDetailUiModel?,
    viewState: PersonDetailViewStateUiModel,
    errorMessage: String,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopCenter
    )
    {
        if (personDetailUiModel != null) {
            Column() {
                ImageCard(personDetailUiModel, {})
                Spacer(Modifier.height(20.dp))
                Text(text = personDetailUiModel.name)
                Spacer(Modifier.height(10.dp))
                Text(text = personDetailUiModel.birthYear)
                Spacer(Modifier.height(10.dp))
                Text(text = personDetailUiModel.gender)
                Spacer(Modifier.height(10.dp))
                Text(text = personDetailUiModel.url)
            }
        }

        LoadingContainer(visible = viewState is Loading)

        if (viewState is Error)
            AlertDialog(
                text = errorMessage,
                onConfirmAction = onCloseDialog,
                onDismissRequest = { viewState is Loading })
    }


}
