package com.example.notesmanager.database

import com.example.notesmanager.ui.model.NoteItem
import io.reactivex.Completable
import io.reactivex.Single

internal interface INoteListRepository {
    fun getList(): Single<List<NoteItem>>

    fun saveNote(noteItem: NoteItem): Completable

    fun deleteNote(noteToDelete: NoteItem): Completable
}
