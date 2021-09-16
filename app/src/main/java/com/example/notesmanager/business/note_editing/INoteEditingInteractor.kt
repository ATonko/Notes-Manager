package com.example.notesmanager.business.note_editing

import com.example.notesmanager.ui.model.NoteItem
import io.reactivex.Completable

internal interface INoteEditingInteractor {

    fun saveNote(noteItem: NoteItem?): Completable

}
