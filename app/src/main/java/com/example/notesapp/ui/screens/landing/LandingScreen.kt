package com.example.notesapp.ui.screens.landing

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.notesapp.ui.screens.landing.components.NoteCard
import com.example.notesapp.viewmodels.LandingScreenVM

@Composable
fun LandingScreen(
    landingScreenVM: LandingScreenVM = hiltViewModel()
) {
    val notesListFlow by landingScreenVM.noteList.collectAsState()
    val notesList by notesListFlow.collectAsState(initial = emptyList())
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        items(
            notesList
        ) {
            NoteCard(note = it)
        }
    }
}
