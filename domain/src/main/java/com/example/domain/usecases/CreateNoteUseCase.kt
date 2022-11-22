package com.example.domain.usecases

import com.example.domain.models.Note
import com.example.domain.repository.NoteRepository
import javax.inject.Inject

class CreateNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(note: Note) = repository.createNote(note)
}
