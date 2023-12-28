package com.sergeikrainyukov.myfavoritedictionary.ui.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergeikrainyukov.myfavoritedictionary.ui.viewModels.PracticeScreenViewModel

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PracticeScreen(viewModel: PracticeScreenViewModel) {

    val words by viewModel.words().observeAsState(initial = emptyList())

    val infinitePagerState = rememberInfinitePagerState()

    if (words.isNotEmpty())
        HorizontalPager(
            state = infinitePagerState,
            contentPadding = PaddingValues(horizontal = 32.dp),
            modifier = Modifier.fillMaxSize()
        ) { page ->
            val index = (page % words.size).let { if (it < 0) it + words.size else it }
            CardItem(word = words[index])
        }
}

@Composable
fun CardItem(word: Word) {
    var showEnglish by remember { mutableStateOf(true) }
    Card(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 32.dp, vertical = 296.dp)
            .clickable { showEnglish = !showEnglish }
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(
                text = if (showEnglish) word.en else word.rus,
                fontSize = 24.sp,
                textAlign = TextAlign.Center,
                color = Color.Black
            )
        }

    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun rememberInfinitePagerState(
    initialPage: Int = 0,
    pageCount: Int = Int.MAX_VALUE,
): PagerState {
    val infinitePagerState = rememberPagerState(
        initialPage = initialPage,
        pageCount = { pageCount },
    )

    LaunchedEffect(infinitePagerState) {
        snapshotFlow { infinitePagerState.currentPage }
            .collect { page ->
                if (page <= 0) {
                    infinitePagerState.scrollToPage(pageCount / 2)
                } else if (page >= pageCount - 1) {
                    infinitePagerState.scrollToPage(pageCount / 2)
                }
            }
    }

    return infinitePagerState
}

data class Word(val en: String, val rus: String)