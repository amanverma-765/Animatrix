package com.akv.animatrix.presentation.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.snapping.rememberSnapFlingBehavior
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.VerticalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.rounded.DateRange
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.twotone.Home
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.akv.animatrix.domain.model.NekoResult
import com.akv.animatrix.domain.util.ApiResult
import com.akv.animatrix.presentation.components.ImageCards
import com.akv.animatrix.presentation.viewmodel.NekoMainViewModel
import com.akv.animatrix.presentation.viewmodel.UiEvents

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(nekoVm: NekoMainViewModel = hiltViewModel()) {

    val uiState by nekoVm.uiStates.collectAsState()

    Scaffold(
        topBar = {
            Column(modifier = Modifier.fillMaxWidth()) {
                TopAppBar(
                    title = { Text(text = "Animatrix") },
                    actions = {
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Rounded.MoreVert, contentDescription = "More")
                        }
                    }
                )

                SearchBar(
                    query = uiState.searchWord,
                    onQueryChange = { word ->
                        nekoVm.onEvent(UiEvents.OnSearchWordChanged(word))
                    },
                    onSearch = {
                        nekoVm.onEvent(UiEvents.OnLoadImages)
                    },
                    active = false,
                    onActiveChange = {},
                    placeholder = { Text(text = "Search...") },
                    trailingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.DateRange,
                            contentDescription = "Date"
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Rounded.Search,
                            contentDescription = "Search"
                        )
                    },
                    windowInsets = WindowInsets(0.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {}
            }
        }
    ) { padding ->
        Column(
            Modifier
                .fillMaxSize()
                .padding(padding)
                .imePadding()
        ) {

            when (val result = uiState.apiState) {

                is ApiResult.Error -> ErrorScreen(error = result.error.name)

                is ApiResult.Loading -> LoadingScreen()

                is ApiResult.Success -> PagerUi(result.data.results)

                is ApiResult.Idle -> DefaultScreen()

            }
        }
    }
}

@Composable
fun DefaultScreen() {

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Rounded.Home ,
            contentDescription = "Home",
            tint = MaterialTheme.colorScheme.secondary,
            modifier = Modifier.size(150.dp)
        )
        
        Text(text = "Search for Anime Characters...")
        
    }
}


@Composable
fun LoadingScreen() {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        CircularProgressIndicator()
    }
}

@Composable
fun ErrorScreen(error: String) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.errorContainer),
        contentAlignment = Alignment.Center
    ) {

        Text(
            text = error,
            style = MaterialTheme.typography.titleMedium,
            color = MaterialTheme.colorScheme.onErrorContainer
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PagerUi(results: List<NekoResult>) {

    val pagerState = rememberPagerState { results.size }

    VerticalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 12.dp),
        pageSpacing = 12.dp,
        modifier = Modifier.fillMaxSize()
    ) {

        ImageCards(imageUrl = results[it].url, name = "")

    }
}