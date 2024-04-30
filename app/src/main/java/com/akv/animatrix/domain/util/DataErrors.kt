package com.akv.animatrix.domain.util

sealed interface DataError: ApiError {

    enum class Network: DataError {
        REQUEST_TIMEOUT,
        TOO_MANY_REQUESTS,
        NO_INTERNET,
        SERVER_ERROR,
        IO_EXCEPTION,
        UNKNOWN
    }
}