package com.example.notecompose.di

import android.app.Application
import androidx.room.Room
import com.example.notecompose.feature_note.data.data_source.NoteDataBase
import com.example.notecompose.feature_note.data.reoisitory.NoteRepositoryImp
import com.example.notecompose.feature_note.domain.repository.NoteRepository
import com.example.notecompose.feature_note.domain.use_case.AddNote
import com.example.notecompose.feature_note.domain.use_case.DeleteNote
import com.example.notecompose.feature_note.domain.use_case.GetNote
import com.example.notecompose.feature_note.domain.use_case.GetNotes
import com.example.notecompose.feature_note.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppMadule {

    @Provides
    @Singleton
    fun provideNoteDataBase(app: Application): NoteDataBase {
        return Room.databaseBuilder(
            app,
            NoteDataBase::class.java,
            NoteDataBase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideRepository(database: NoteDataBase): NoteRepository {
        return NoteRepositoryImp(database.noteDao)
    }

    @Provides
    @Singleton
    fun provideNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}