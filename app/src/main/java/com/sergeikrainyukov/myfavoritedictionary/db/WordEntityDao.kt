package com.sergeikrainyukov.myfavoritedictionary.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WordEntityDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(wordEntity: WordEntity)

    @Query("SELECT * FROM wordentity")
    fun getAll(): LiveData<List<WordEntity>>

}