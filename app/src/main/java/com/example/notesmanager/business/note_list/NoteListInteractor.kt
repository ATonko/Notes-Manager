package com.example.notesmanager.business.note_list

import com.example.notesmanager.database.INoteListRepository
import com.example.notesmanager.ui.model.NoteItem
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class NoteListInteractor @Inject constructor(
    private val repository: INoteListRepository
) : INoteListInteractor {

    override fun getList(): Single<List<NoteItem>> = repository.getList()

    override fun deleteNote(noteToDelete: NoteItem): Completable =repository.deleteNote(noteToDelete)

}