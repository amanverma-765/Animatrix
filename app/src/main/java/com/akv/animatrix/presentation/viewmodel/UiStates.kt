package com.akv.animatrix.presentation.viewmodel

import com.akv.animatrix.domain.model.Neko
import com.akv.animatrix.domain.util.ApiResult
import com.akv.animatrix.domain.util.DataError

data class UiStates(

    val apiState: ApiResult<Neko, DataError.Network>,
    val searchWord: String = "",
)

