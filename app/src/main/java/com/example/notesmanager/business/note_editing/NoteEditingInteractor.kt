package com.example.notesmanager.business.note_editing

import com.example.notesmanager.database.INoteListRepository
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.utils.NoteToSaveNullError
import io.reactivex.Completable
import javax.inject.Inject

internal class NoteEditingInteractor @Inject constructor(
    private val repository: INoteListRepository
) : INoteEditingInteractor {

    override fun saveNote(noteItem: NoteItem?): Completable =
        if (noteItem != null) {
            repository.saveNote(noteItem)
        } else {
            Completable.error(NoteToSaveNullError())
        }

}
