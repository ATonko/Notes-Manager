package com.example.notesmanager.ui.note_editing.presenter

import com.example.notesmanager.core.mvp.IPresenter
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.ui.note_editing.view.INoteEditingView

internal interface INoteEditingPresenter : IPresenter<INoteEditingView> {

    fun onViewReady(noteItem: NoteItem)

    fun onMenuItemClick(noteContent: String)

    fun onBackPressed(noteContentToSave: String)
}
