package com.example.domain.repository

import com.example.domain.models.Note
import dagger.Provides
import kotlinx.coroutines.flow.Flow

interface NoteRepository {
    suspend fun createNote(note: Note): Boolean
    suspend fun readNotes(): Flow<List<Note>>
    suspend fun updateNote(note: Note): Boolean
    suspend fun deleteNote(nodeId: Int): Boolean
}
