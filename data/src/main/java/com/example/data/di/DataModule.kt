package com.example.data.di

import android.content.Context
import androidx.room.Room
import com.example.data.repository.NoteRepositoryImplementation
import com.example.data.sources.local.NoteDatabase
import com.example.data.sources.local.NotesDao
import com.example.domain.repository.NoteRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Singleton
    @Provides
    fun provideNoteDatabase(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, NoteDatabase::class.java, "note_database").build()

    @Singleton
    @Provides
    fun provideNoteDao(noteDb: NoteDatabase) = noteDb.getNotesDao()

    @Singleton
    @Provides
    fun provideNoteRepository(dao: NotesDao): NoteRepository = NoteRepositoryImplementation(dao)
}
