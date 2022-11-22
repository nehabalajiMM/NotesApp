package com.example.data.mappers

import com.example.data.models.DNote
import com.example.domain.models.Note

fun Note.toDNote() = DNote(id, title, body)
fun DNote.toNote() = Note(id, title, body)
