package com.sergeikrainyukov.myfavoritedictionary.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.sergeikrainyukov.myfavoritedictionary.db.WordEntityDao
import com.sergeikrainyukov.myfavoritedictionary.ui.screens.Word

interface WordsRepository {
    fun getWords(): LiveData<List<Word>>
}

class WordsRepositoryImpl(
    private val wordEntityDao: WordEntityDao
) : WordsRepository {
    override fun getWords(): LiveData<List<Word>> {
        return wordEntityDao.getAll().map {
            it.map { Word(it.en, it.rus) }
        }
    }
}
