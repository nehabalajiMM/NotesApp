package com.example.domain.models

import com.example.domain.usecases.CreateNoteUseCase
import com.example.domain.usecases.DeleteNoteUseCase
import com.example.domain.usecases.ReadNoteUseCase
import com.example.domain.usecases.UpdateNoteUseCase

data class NoteUseCases(
    val createNoteUseCase: CreateNoteUseCase,
    val readNoteUseCase: ReadNoteUseCase,
    val updateNoteUseCase: UpdateNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase
)
