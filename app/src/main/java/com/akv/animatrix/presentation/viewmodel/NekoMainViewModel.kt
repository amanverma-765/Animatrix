package com.akv.animatrix.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.akv.animatrix.domain.repository.NekoRepository
import com.akv.animatrix.domain.util.ApiResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NekoMainViewModel @Inject constructor(
    private val nekoRepository: NekoRepository
) : ViewModel() {

    private val _uiStates = MutableStateFlow(UiStates(ApiResult.Idle()))
    val uiStates = _uiStates.asStateFlow()

    fun onEvent(event: UiEvents) {
        when (event) {
            is UiEvents.OnLoadImages -> getImages()
            is UiEvents.OnSearchWordChanged -> _uiStates.update { state ->
                state.copy(searchWord = event.newWord)
            }
        }
    }

    private fun getImages() {
        viewModelScope.launch {

            nekoRepository.getImages(
                query = _uiStates.value.searchWord
            ).collect { apiResult ->

                _uiStates.update {
                    it.copy(
                        apiState = apiResult
                    )
                }
            }
        }
    }

}