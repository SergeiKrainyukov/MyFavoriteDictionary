package com.sergeikrainyukov.myfavoritedictionary.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.sergeikrainyukov.myfavoritedictionary.db.AppDatabase
import com.sergeikrainyukov.myfavoritedictionary.ui.screens.Word

class DictionaryScreenViewModel(
    private val appDatabase: AppDatabase
) : ViewModel() {
    fun getAllWords() = appDatabase.wordEntityDao().getAll().map { it.map { Word(it.en, it.rus) } }
}