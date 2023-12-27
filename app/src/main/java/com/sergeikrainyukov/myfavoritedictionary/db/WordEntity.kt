package com.sergeikrainyukov.myfavoritedictionary.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WordEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "rus") val rus: String,
    @ColumnInfo(name = "en") val en: String,
)