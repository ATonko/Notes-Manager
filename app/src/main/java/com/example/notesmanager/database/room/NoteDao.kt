package com.example.notesmanager.database.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
internal interface NoteDao {

    @Query("SELECT * FROM ${NoteRoomEntity.TABLE_NAME}")
    fun getList(): Single<List<NoteRoomEntity>>

    @Query("SELECT count(*) FROM notes")
    fun getNotesAmount(): Int

    @Insert
    fun saveNote(note: NoteRoomEntity): Completable

    @Delete
    fun deleteNote(note: NoteRoomEntity): Completable

    @Insert
    fun insertAll(vararg notes: NoteRoomEntity)
}