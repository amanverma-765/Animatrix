package com.akv.animatrix.data.remote.api

import com.akv.animatrix.data.remote.model.NekoDto

interface NekoApi {

    suspend fun getImages(query: String): NekoDto

    companion object {
        const val BASE_URL = "https://nekos.best"
    }
}