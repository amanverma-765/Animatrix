package com.akv.animatrix.data.remote.repository

import android.util.Log
import com.akv.animatrix.data.remote.api.ktor.KtorNekoApi
import com.akv.animatrix.data.remote.mapper.NekoMapper.toNeko
import com.akv.animatrix.domain.model.Neko
import com.akv.animatrix.domain.repository.NekoRepository
import com.akv.animatrix.domain.util.ApiResult
import com.akv.animatrix.domain.util.DataError
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestTimeoutException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.utils.io.errors.IOException
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.nio.channels.UnresolvedAddressException
import javax.inject.Inject

class NekoRepositoryImpl @Inject constructor(

    private val ktorNekoApi: KtorNekoApi

) : NekoRepository {

    override fun getImages(query: String): Flow<ApiResult<Neko, DataError.Network>> {

        return flow {

            emit(ApiResult.Loading())

            val remoteImage = try {

                ktorNekoApi.getImages(query)

            } catch (e: HttpRequestTimeoutException) {
                e.printStackTrace()
                emit(ApiResult.Error(DataError.Network.REQUEST_TIMEOUT))
                return@flow
            } catch (e: ServerResponseException) {
                e.printStackTrace()
                emit(ApiResult.Error(DataError.Network.SERVER_ERROR))
                return@flow
            } catch (e: ClientRequestException) {
                e.printStackTrace()
                emit(ApiResult.Error(DataError.Network.TOO_MANY_REQUESTS))
                return@flow
            } catch (e: IOException) {
                e.printStackTrace()
                emit(ApiResult.Error(DataError.Network.IO_EXCEPTION))
                return@flow
            } catch (e: UnresolvedAddressException) {
                e.printStackTrace()
                emit(ApiResult.Error(DataError.Network.NO_INTERNET))
                return@flow
            } catch (e: Exception) {
                e.printStackTrace()
                emit(ApiResult.Error(DataError.Network.UNKNOWN))
                return@flow
            }

            emit(ApiResult.Success(remoteImage.toNeko()))
            return@flow
        }
    }
}