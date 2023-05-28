package com.example.notecompose.feature_note.domain.use_case

import com.example.notecompose.feature_note.domain.model.InvalidationNoteException
import com.example.notecompose.feature_note.domain.model.Note
import com.example.notecompose.feature_note.domain.repository.NoteRepository

class AddNote(private val repository: NoteRepository) {

    @Throws(InvalidationNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) throw InvalidationNoteException("The title of the note can't be empty.")

        if (note.content.isBlank()) throw InvalidationNoteException("The content of the note can't be empty.")

        repository.insertNote(note)
    }
}