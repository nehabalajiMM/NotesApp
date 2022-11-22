package com.example.domain.di

import com.example.domain.repository.NoteRepository
import com.example.domain.usecases.CreateNoteUseCase
import com.example.domain.usecases.DeleteNoteUseCase
import com.example.domain.usecases.ReadNoteUseCase
import com.example.domain.usecases.UpdateNoteUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Singleton
    @Provides
    fun provideCreateNoteUseCase(noteRepository: NoteRepository) = CreateNoteUseCase(noteRepository)

    @Singleton
    @Provides
    fun provideReadNoteUseCase(noteRepository: NoteRepository) = ReadNoteUseCase(noteRepository)

    @Singleton
    @Provides
    fun provideUpdateNoteUseCase(noteRepository: NoteRepository) = UpdateNoteUseCase(noteRepository)

    @Singleton
    @Provides
    fun provideDeleteNoteUseCase(noteRepository: NoteRepository) = DeleteNoteUseCase(noteRepository)
}
