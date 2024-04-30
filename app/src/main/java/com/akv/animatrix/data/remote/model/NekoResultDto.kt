package com.akv.animatrix.data.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NekoResultDto(

    @SerialName("artist_name")
    val artistName: String,

    @SerialName("url")
    val url: String
)