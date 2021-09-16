package com.example.notesmanager.ui.notes_list.view

import com.example.notesmanager.core.mvp.IView
import com.example.notesmanager.ui.model.NoteItem

internal interface INotesListView : IView {

    fun setNoteList(notes: List<NoteItem>)

    fun goToNoteEditing(noteItem: NoteItem)

    fun setToolbar(title: String)

    fun updateNoteList(list: List<NoteItem>)
}
