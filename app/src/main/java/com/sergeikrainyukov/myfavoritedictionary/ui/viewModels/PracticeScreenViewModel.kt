package com.sergeikrainyukov.myfavoritedictionary.ui.viewModels

import androidx.lifecycle.ViewModel
import com.sergeikrainyukov.myfavoritedictionary.repositories.WordsRepositoryImpl

class PracticeScreenViewModel : ViewModel() {
    val words = WordsRepositoryImpl().getWords()
}