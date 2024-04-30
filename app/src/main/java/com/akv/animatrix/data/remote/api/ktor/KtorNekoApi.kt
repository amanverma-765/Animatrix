package com.akv.animatrix.data.remote.api.ktor

import com.akv.animatrix.data.remote.api.NekoApi
import com.akv.animatrix.data.remote.model.NekoDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import javax.inject.Inject

class KtorNekoApi @Inject constructor(private val ktorClient: HttpClient) : NekoApi {
    override suspend fun getImages(query: String): NekoDto {

        return ktorClient.get("/api/v2/search?query=$query&type=1&amount=20")
            .body<NekoDto>()

    }
}