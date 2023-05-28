package com.example.notecompose.feature_note.presentatiion.util

sealed class Screen(
    val route:String
){
    object NotesScreen:Screen("notes_screen")
    object AddEditeNoteScreen:Screen("add_edit_note_screen")
}
