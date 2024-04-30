package com.akv.animatrix.presentation.viewmodel

sealed interface UiEvents {

    data object OnLoadImages: UiEvents
    data class OnSearchWordChanged(val newWord: String) : UiEvents
}