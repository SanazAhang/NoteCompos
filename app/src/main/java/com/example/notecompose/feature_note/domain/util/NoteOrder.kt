package com.example.notecompose.feature_note.domain.util

sealed class NoteOrder(val ordetType: OrderType) {
    class Title(ordertype: OrderType) : NoteOrder(ordertype)
    class Date(ordertype: OrderType) : NoteOrder(ordertype)
    class Color(ordertype: OrderType) : NoteOrder(ordertype)

    fun copy(ordertype: OrderType): NoteOrder {
        return when (this) {
            is Title -> Title(ordertype)
            is Date -> Date(ordertype)
            is Color -> Color(ordertype)
        }
    }
}
