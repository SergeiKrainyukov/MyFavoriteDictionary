package com.sergeikrainyukov.myfavoritedictionary.ui.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sergeikrainyukov.myfavoritedictionary.db.AppDatabase
import com.sergeikrainyukov.myfavoritedictionary.db.WordEntity
import kotlinx.coroutines.launch

class AddWordScreenViewModel(private val appDatabase: AppDatabase) : ViewModel() {
    fun saveWord(en: String, rus: String) {
        viewModelScope.launch {
            if (en.isNotBlank() && rus.isNotBlank())
                appDatabase.wordEntityDao().insert(WordEntity(en = en, rus = rus))
        }
    }
}