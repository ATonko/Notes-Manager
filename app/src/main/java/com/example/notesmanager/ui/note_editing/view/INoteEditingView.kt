package com.example.notesmanager.ui.note_editing.view

import com.example.notesmanager.core.mvp.IView

internal interface INoteEditingView : IView {

    fun setToolbar(title:String)

    fun clearEditNoteFieldFocus()

    fun setContent(content: String)

    fun goToNoteList()

    fun goBackToNoteList()

}
