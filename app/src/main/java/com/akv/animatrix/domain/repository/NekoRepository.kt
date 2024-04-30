package com.akv.animatrix.domain.repository

import com.akv.animatrix.domain.model.Neko
import com.akv.animatrix.domain.util.ApiResult
import com.akv.animatrix.domain.util.DataError
import kotlinx.coroutines.flow.Flow

interface NekoRepository {

    fun getImages(query: String): Flow<ApiResult<Neko, DataError.Network>>
}