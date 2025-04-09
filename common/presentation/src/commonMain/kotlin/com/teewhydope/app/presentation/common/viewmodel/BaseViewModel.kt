package com.teewhydope.app.presentation.common.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.teewhydope.app.domain.common.model.exception.DomainException
import com.teewhydope.app.domain.common.usecase.BaseUseCase
import com.teewhydope.app.domain.common.usecase.UseCaseExecutor
import com.teewhydope.app.logger.globalLogger
import com.teewhydope.app.presentation.common.internal.exception.GeneralDomainToPresentationExceptionMapper
import com.teewhydope.app.presentation.common.internal.exception.PresentationException
import com.teewhydope.app.presentation.common.mapper.DomainToPresentationMapper
import com.teewhydope.app.presentation.common.navigation.PresentationNavigationEvent
import com.teewhydope.app.presentation.common.navigation.PresentationNavigationEvent.Back
import com.teewhydope.app.presentation.common.notification.PresentationNotification
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel<VIEW_STATE : Any, NOTIFICATION : PresentationNotification> :
    ViewModel() {

    open val generalExceptionMapper:
            DomainToPresentationMapper<in DomainException, out PresentationException> =
        GeneralDomainToPresentationExceptionMapper()

    private val _notification by mutableSharedFlow<NOTIFICATION>()
    val notification by immutableFlow { _notification }

    private val _navigationEvent by mutableSharedFlow<PresentationNavigationEvent>()
    val navigationEvent by immutableFlow { _navigationEvent }

    private val _presentationExceptionEvents by mutableSharedFlow<PresentationException>()
    val presentationExceptionEvents by immutableFlow { _presentationExceptionEvents }

    private val _viewState by mutableStateFlow { initialState() }
    val viewState by immutableFlow { _viewState }

    private val useCaseExecutor: UseCaseExecutor = UseCaseExecutor(viewModelScope)

    protected fun navigate(navigationEvent: PresentationNavigationEvent) {
        MainScope().launch {
            _navigationEvent.emit(navigationEvent)
        }
    }

    protected fun notify(notification: NOTIFICATION) {
        MainScope().launch {
            _notification.emit(notification)
        }
    }

    protected fun navigateBack() {
        MainScope().launch {
            _navigationEvent.emit(Back)
        }
    }


    fun updateState(newViewState: VIEW_STATE) {
        _viewState.value = newViewState
    }

    fun updateState(updatedState: (lastState: VIEW_STATE) -> VIEW_STATE) =
        updateState(updatedState(currentViewState)).also {
            globalLogger.v("Updated state ${updatedState(currentViewState)}")
        }

    fun presentError(exception: PresentationException) {
        globalLogger.e(exception)
        MainScope().launch {
            _presentationExceptionEvents.emit(exception)
        }
    }

    fun presentError(exception: DomainException) {
        presentError(generalExceptionMapper.toPresentation(exception))
    }

    private fun <T> mutableStateFlow(initialValueProvider: () -> T) =
        lazy { MutableStateFlow(initialValueProvider()) }

    private fun <T> mutableSharedFlow() = lazy { MutableSharedFlow<T>() }

    private fun <T, FLOW : MutableSharedFlow<T>> immutableFlow(
        initializer: () -> FLOW
    ): Lazy<Flow<T>> = lazy { initializer() }

    val currentViewState = _viewState.value

    abstract fun initialState(): VIEW_STATE

    override fun onCleared() {
        super.onCleared()
        viewModelScope.cancel("Scope cleared")
    }

    protected operator fun <OUTPUT> BaseUseCase<Unit, OUTPUT>.invoke(
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        useCaseExecutor.execute(this, onResult, onException)
    }

    protected operator fun <INPUT, OUTPUT> BaseUseCase<INPUT, OUTPUT>.invoke(
        value: INPUT,
        onResult: (OUTPUT) -> Unit = {},
        onException: (DomainException) -> Unit = {}
    ) {
        useCaseExecutor.execute(this, value, onResult, onException)
    }
}
