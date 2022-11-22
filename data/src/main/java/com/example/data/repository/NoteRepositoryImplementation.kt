package com.example.data.repository

import com.example.data.mappers.toDNote
import com.example.data.mappers.toNote
import com.example.data.sources.local.NotesDao
import com.example.domain.models.Note
import com.example.domain.repository.NoteRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class NoteRepositoryImplementation @Inject constructor(
    private val notesDao: NotesDao
) : NoteRepository {
    override suspend fun createNote(note: Note): Boolean {
        return try {
            notesDao.createNote(note.toDNote())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun readNotes(): Flow<List<Note>> {
        return notesDao.readNotes().map { dNoteList ->
            dNoteList.map {
                it.toNote()
            }
        }
    }

    override suspend fun updateNote(note: Note): Boolean {
        return try {
            notesDao.updateNote(note.toDNote())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun deleteNote(nodeId: Int): Boolean {
        return try {
            notesDao.deleteNote(nodeId)
            true
        } catch (e: Exception) {
            false
        }
    }
}