package com.example.notesmanager.di

import com.example.notesmanager.di.note_editing.NoteEditingComponent
import com.example.notesmanager.di.note_list.NoteListComponent

internal object ComponentManager {

    private var noteListComponent: NoteListComponent? = null
    private var noteEditingComponent: NoteEditingComponent? = null


    fun plusNoteListComponent(): NoteListComponent =
        noteListComponent ?: DaggerManager.plusAppComponent()
            .plusNoteListComponent()
            .also { noteListComponent = it }

    fun plusNoteEditingFragment(): NoteEditingComponent =
        noteEditingComponent ?: DaggerManager.plusAppComponent()
            .plusNoteEditingComponent()
            .also { noteEditingComponent = it }

    fun clearNoteListComponent() {
        noteListComponent = null
    }

    fun clearNoteEditingComponent() {
        noteEditingComponent = null
    }
}