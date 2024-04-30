package com.akv.animatrix.domain.util

typealias RootError = ApiError

sealed interface ApiResult<out D, out E: RootError> {

    data class Success<out D, out E: RootError>(val data: D): ApiResult<D, E>
    data class Error<out D, out E: RootError>(val error: E): ApiResult<D, E>
    class Loading<out D, out E: RootError>: ApiResult<D, E>
    class Idle<out D, out E: RootError>: ApiResult<D, E>

}

sealed interface ApiError

