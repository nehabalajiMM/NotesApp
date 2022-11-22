package com.example.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_table")
data class DNote(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val title: String,
    val body: String
)
