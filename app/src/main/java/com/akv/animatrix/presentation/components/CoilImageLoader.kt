package com.akv.animatrix.presentation.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.CachePolicy
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers

@Composable
fun CoilImageLoader(
    modifier: Modifier = Modifier,
    imgUri: String,
    contentScale: ContentScale = ContentScale.Crop
) {

    AsyncImage(
        modifier = modifier,
        model = ImageRequest.Builder(LocalContext.current)
            .data(imgUri)
            .diskCacheKey(imgUri)
            .crossfade(true)
            .dispatcher(Dispatchers.IO)
            .diskCachePolicy(CachePolicy.ENABLED)
            .build(),
//        placeholder = painterResource(id = R.drawable),
        contentDescription = null,
        contentScale = contentScale
    )
}

