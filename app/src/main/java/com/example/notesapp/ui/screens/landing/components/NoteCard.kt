package com.example.notesapp.ui.screens.landing.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.domain.models.Note

@Composable
fun NoteCard(note: Note) {
    Card {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "#${note.id}"
            )
            Column {
                Text(
                    text = note.title
                )
                Text(
                    text = note.body
                )
            }
        }
    }
}

@Preview
@Composable
fun NoteCardPreview() {
    NoteCard(Note(1, "my_title", "my_body"))
}
