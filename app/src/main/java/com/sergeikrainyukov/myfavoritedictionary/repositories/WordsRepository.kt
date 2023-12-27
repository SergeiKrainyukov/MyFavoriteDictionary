package com.sergeikrainyukov.myfavoritedictionary.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.sergeikrainyukov.myfavoritedictionary.ui.screens.Word

interface WordsRepository {
    fun getWords(): LiveData<List<Word>>
}

class WordsRepositoryImpl : WordsRepository {
    override fun getWords(): LiveData<List<Word>> {
        return MutableLiveData(
            listOf(
                Word("Card 1", "Карточка 1"),
                Word("Card 2", "Карточка 2"),
                Word("Card 3", "Карточка 3")
            )
        )
    }
}
