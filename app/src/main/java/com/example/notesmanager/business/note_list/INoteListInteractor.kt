package com.example.notesmanager.business.note_list

import com.example.notesmanager.ui.model.NoteItem
import io.reactivex.Completable
import io.reactivex.Single

internal interface INoteListInteractor {

    fun getList(): Single<List<NoteItem>>

    fun deleteNote(noteToDelete: NoteItem):Completable
}