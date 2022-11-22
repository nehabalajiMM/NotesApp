package com.example.data.sources.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.models.DNote

@Database(
    entities = [DNote::class],
    version = 1,
    exportSchema = false
)
abstract class NoteDatabase : RoomDatabase() {
    abstract fun getNotesDao(): NotesDao
}
