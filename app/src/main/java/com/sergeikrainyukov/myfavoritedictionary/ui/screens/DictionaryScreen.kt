package com.sergeikrainyukov.myfavoritedictionary.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sergeikrainyukov.myfavoritedictionary.ui.viewModels.DictionaryScreenViewModel

@Composable
fun DictionaryScreen(viewModel: DictionaryScreenViewModel) {
    val words by viewModel.getAllWords().observeAsState(initial = emptyList())

    LazyColumn {
        items(words.count()) {
            WordItem(words[it])
        }
    }
}

@Composable
fun WordItem(word: Word) {
    Text(text = word.en.plus(" - ".plus(word.rus)), modifier = Modifier.padding(16.dp))
}
