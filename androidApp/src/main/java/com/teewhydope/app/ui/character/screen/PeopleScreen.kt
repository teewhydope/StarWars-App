package com.teewhydope.app.ui.character.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.teewhydope.app.common.navigation.mapper.NavigationEventDestinationMapper
import com.teewhydope.app.common.view.BaseComposeHolder
import com.teewhydope.app.common.view.ScreenEnterObserver
import com.teewhydope.app.common.widgets.AlertDialog
import com.teewhydope.app.common.widgets.LoadingContainer
import com.teewhydope.app.presentation.character.model.PeopleListPresentationNavigationEvent
import com.teewhydope.app.presentation.character.viewmodel.PeopleListViewModel
import com.teewhydope.app.presentation.character.viewmodel.PeopleListViewState
import com.teewhydope.app.presentation.common.notification.PresentationNotification
import com.teewhydope.app.ui.character.mapper.PeopleListErrorPresentationToUiExceptionMapper
import com.teewhydope.app.ui.character.mapper.PeopleListViewStatePresentationToUiMapper
import com.teewhydope.app.ui.character.mapper.PeoplePresentationToUiModelMapper
import com.teewhydope.app.ui.character.model.PeopleListViewStateUiModel
import com.teewhydope.app.ui.character.model.PeopleListViewStateUiModel.*
import com.teewhydope.app.ui.character.model.PeopleUiModel
import com.teewhydope.app.ui.character.widget.ImageCard


data class PeopleScreenDependencies(
    val viewModel: PeopleListViewModel,
    val peoplePresentationToUiModelMapper: PeoplePresentationToUiModelMapper,
    val peopleListViewStatePresentationToUiMapper: PeopleListViewStatePresentationToUiMapper,
    private val peopleListNavigationMapper:
    NavigationEventDestinationMapper<PeopleListPresentationNavigationEvent>,
    val peopleListErrorPresentationToUiExceptionMapper: PeopleListErrorPresentationToUiExceptionMapper,
) : BaseComposeHolder<PeopleListViewState, PresentationNotification>(
    viewModel,
    peopleListNavigationMapper,
    null
)


@Composable
fun PeopleScreenDependencies.People(navController: NavController) {

    ScreenEnterObserver {
        viewModel.fetchPeople()
        //viewModel.fetchPersonDetail(1)
    }

    ViewModelObserver(navController)


    val viewState by viewModel.viewState.collectAsState(PeopleListViewState.Loading)

    val peopleUiModel =
        (viewState as? PeopleListViewState.Loaded)?.let(peoplePresentationToUiModelMapper::toUi)


    val errorMessage = (viewState as? PeopleListViewState.Error)
        ?.let(peopleListErrorPresentationToUiExceptionMapper::toUi).orEmpty()

    val uiState by rememberSaveable(viewState) {
        mutableStateOf(peopleListViewStatePresentationToUiMapper.toUi(viewState))
    }


    PeopleListContent(
        viewState = uiState,
        peopleUiModel = peopleUiModel,
        errorMessage = errorMessage,
        onCloseDialog = { viewModel.fetchPeople() },
        onViewDetailsClick = { id -> viewModel.onViewDetailsAction(id) }
    )
}

@Composable
fun PeopleListContent(
    onCloseDialog: () -> Unit,
    peopleUiModel: PeopleUiModel?,
    viewState: PeopleListViewStateUiModel,
    errorMessage: String,
    onViewDetailsClick: (Int) -> Unit,
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        if (peopleUiModel != null)
            LazyColumn {
                items(peopleUiModel.results) { item ->
                    ImageCard(
                        item,
                        onViewDetailsClick,
                    )
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

