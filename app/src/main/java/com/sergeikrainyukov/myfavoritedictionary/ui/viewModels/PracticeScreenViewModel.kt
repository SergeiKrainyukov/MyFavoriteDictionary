package com.sergeikrainyukov.myfavoritedictionary.ui.viewModels

import androidx.lifecycle.ViewModel
import com.sergeikrainyukov.myfavoritedictionary.db.AppDatabase
import com.sergeikrainyukov.myfavoritedictionary.repositories.WordsRepositoryImpl

class PracticeScreenViewModel(private val appDatabase: AppDatabase) : ViewModel() {
    fun words() = WordsRepositoryImpl(appDatabase.wordEntityDao()).getWords()
}