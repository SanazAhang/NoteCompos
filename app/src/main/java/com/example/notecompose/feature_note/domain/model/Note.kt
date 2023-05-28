package com.example.notecompose.feature_note.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notecompose.ui.theme.BabyBlue
import com.example.notecompose.ui.theme.LightGreen
import com.example.notecompose.ui.theme.RedOrang
import com.example.notecompose.ui.theme.RedPink
import com.example.notecompose.ui.theme.Violet

@Entity
data class Note(
    val title:String,
    val content:String,
    val timeStamp:Long,
    val color:Int,
    @PrimaryKey val id:Int? = null
){
    companion object{
        val noteColors = listOf(RedOrang,LightGreen,Violet,BabyBlue,RedPink)
    }
}


class InvalidationNoteException(message:String):Exception(message)

