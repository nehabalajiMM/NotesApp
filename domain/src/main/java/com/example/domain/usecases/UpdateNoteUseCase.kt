package com.example.domain.usecases

import com.example.domain.models.Note
import com.example.domain.repository.NoteRepository

class UpdateNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = repository.updateNote(note)
}