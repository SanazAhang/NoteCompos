package com.example.notecompose.feature_note.presentatiion.notes

import com.example.notecompose.feature_note.domain.model.Note
import com.example.notecompose.feature_note.domain.util.NoteOrder
import com.example.notecompose.feature_note.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Decending),
    val isOrderSectionVisible: Boolean = false
)
