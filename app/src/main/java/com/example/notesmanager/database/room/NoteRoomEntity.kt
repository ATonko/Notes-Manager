package com.example.notesmanager.database.room

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.notesmanager.database.room.NoteRoomEntity.Companion.TABLE_NAME
import com.example.notesmanager.utils.Constants.EMPTY_STRING

@Entity(tableName = TABLE_NAME)
data class NoteRoomEntity(
    @PrimaryKey
    val id: String,
    var title: String,
    var content: String = EMPTY_STRING
){
    internal companion object{
        const val TABLE_NAME="notes"
    }
}
