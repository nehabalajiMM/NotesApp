package com.example.notesapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.models.Note
import com.example.domain.models.NoteUseCases
import com.example.domain.usecases.CreateNoteUseCase
import com.example.domain.usecases.ReadNoteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LandingScreenVM @Inject constructor(
    private val createNoteUseCase: CreateNoteUseCase,
    private val readNoteUseCase: ReadNoteUseCase
) : ViewModel() {

    private val _noteList = MutableStateFlow<Flow<List<Note>>>(emptyFlow())
    var noteList = _noteList.asStateFlow()

    init {
        insertNoteIntoDb(Note(title = "test1", body = "test_body"))
        insertNoteIntoDb(Note(title = "test2", body = "test_body"))
        insertNoteIntoDb(Note(title = "test3", body = "test_body"))
        insertNoteIntoDb(Note(title = "test4", body = "test_body"))
        fetchNotesFromDb()
    }

    private fun fetchNotesFromDb() = viewModelScope.launch {
        _noteList.value = readNoteUseCase()
    }

    fun insertNoteIntoDb(note: Note) {
        viewModelScope.launch {
            createNoteUseCase(note)
        }
    }
}
