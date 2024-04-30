package com.akv.animatrix.data.remote.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NekoDto(

    @SerialName("results")
    val results: List<NekoResultDto>

)