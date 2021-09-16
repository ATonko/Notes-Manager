package com.example.notesmanager.database.repositories.mock

import com.example.notesmanager.database.INoteListRepository
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.utils.MockData
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject

internal class MockListRepository @Inject constructor() : INoteListRepository {

    override fun getList(): Single<List<NoteItem>> =
            Single.just(MockData.getMockNoteList())

    override fun saveNote(noteItem: NoteItem): Completable =
            Completable.fromAction { MockData.saveNote(noteItem) }

    override fun deleteNote(noteToDelete: NoteItem): Completable =
            Completable.fromAction { MockData.deleteNote(noteToDelete) }
}