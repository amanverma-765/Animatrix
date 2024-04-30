package com.akv.animatrix.data.remote.mapper

import com.akv.animatrix.data.remote.model.NekoDto
import com.akv.animatrix.data.remote.model.NekoResultDto
import com.akv.animatrix.domain.model.Neko
import com.akv.animatrix.domain.model.NekoResult


object NekoMapper {

    private fun NekoResultDto.toNekoResult(): NekoResult {
        return NekoResult(
            artistName = artistName,
            url = url
        )
    }

    fun NekoDto.toNeko(): Neko {
        return Neko(
            results = results.map {
                it.toNekoResult()
            }
        )
    }
}