package com.example.notesmanager.ui.notes_list.presenter

import com.example.notesmanager.core.mvp.IPresenter
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.ui.notes_list.view.INotesListView

internal interface INotesListPresenter:IPresenter<INotesListView>{

    fun onNoteItemClick(noteItem: NoteItem)

    fun onNewNoteClick()

    fun onNoteItemLongClick(noteItem: NoteItem)
}
