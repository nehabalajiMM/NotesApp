package com.example.data.sources.local

import androidx.room.*
import com.example.data.models.DNote
import kotlinx.coroutines.flow.Flow

@Dao
interface NotesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createNote(dNote: DNote)

    @Query("SELECT * FROM note_table")
    fun readNotes(): Flow<List<DNote>>

    @Update
    suspend fun updateNote(dNote: DNote)

    @Query("DELETE FROM note_table WHERE id=:dNoteId")
    suspend fun deleteNote(dNoteId: Int)
}