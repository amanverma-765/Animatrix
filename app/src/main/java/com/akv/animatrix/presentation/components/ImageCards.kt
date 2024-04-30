package com.akv.animatrix.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp

@Composable
fun ImageCards(
    modifier: Modifier = Modifier,
    imageUrl: String,
    name: String,
) {

    Card(
        modifier = modifier
            .aspectRatio(9f/16f)
            .clip(RoundedCornerShape(16.dp))
    ) {

        Box(
            contentAlignment = Alignment.BottomCenter,
            modifier = Modifier.fillMaxSize()
        ) {

            CoilImageLoader(
                imgUri = imageUrl,
                modifier = Modifier.fillMaxSize()
            )

            Text(text = name)

        }
    }
}