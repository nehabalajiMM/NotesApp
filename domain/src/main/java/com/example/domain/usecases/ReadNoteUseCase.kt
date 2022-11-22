package com.example.domain.usecases

import com.example.domain.models.Note
import com.example.domain.repository.NoteRepository
import javax.inject.Inject

class ReadNoteUseCase(
    private val repository: NoteRepository
) {
    suspend operator fun invoke() = repository.readNotes()
}