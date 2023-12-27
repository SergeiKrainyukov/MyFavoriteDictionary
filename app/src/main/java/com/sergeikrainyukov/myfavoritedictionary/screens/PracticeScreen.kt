package com.sergeikrainyukov.myfavoritedictionary.screens

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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sergeikrainyukov.myfavoritedictionary.ui.theme.MyFavoriteDictionaryTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PracticeScreen() {
    val cardTexts = listOf(
        Word("Card 1", "Карточка 1"),
        Word("Card 2", "Карточка 2"),
        Word("Card 3", "Карточка 3")
    )
    val infinitePagerState = rememberInfinitePagerState()

    HorizontalPager(
        state = infinitePagerState,
        contentPadding = PaddingValues(horizontal = 32.dp),
        modifier = Modifier.fillMaxSize()
    ) { page ->
        val index = (page % cardTexts.size).let { if (it < 0) it + cardTexts.size else it }
        CardItem(word = cardTexts[index])
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
                text = if (showEnglish) word.eng else word.rus,
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

data class Word(val eng: String, val rus: String)


@Preview(showBackground = true)
@Composable
fun BattleScreenPreview() {
    MyFavoriteDictionaryTheme {
        PracticeScreen()
    }
}