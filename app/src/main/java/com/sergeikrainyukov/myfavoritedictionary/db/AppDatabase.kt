package com.sergeikrainyukov.myfavoritedictionary.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.sergeikrainyukov.myfavoritedictionary.db.AppDatabase.Companion.DATABASE_VERSION

@Database(
    entities = [WordEntity::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME: String = "CallDefenderDb"
        const val DATABASE_VERSION = 1
    }

    abstract fun wordEntityDao(): WordEntityDao

}

object DbProvider {

    fun provideAppDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            AppDatabase.DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}