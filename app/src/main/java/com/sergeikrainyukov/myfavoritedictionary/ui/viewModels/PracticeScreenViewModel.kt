package com.sergeikrainyukov.myfavoritedictionary.ui.viewModels

import androidx.lifecycle.ViewModel
import com.sergeikrainyukov.myfavoritedictionary.db.AppDatabase
import com.sergeikrainyukov.myfavoritedictionary.repositories.WordsRepositoryImpl

class PracticeScreenViewModel(appDatabase: AppDatabase) : ViewModel() {
    val words = WordsRepositoryImpl(appDatabase.wordEntityDao()).getWords()
}