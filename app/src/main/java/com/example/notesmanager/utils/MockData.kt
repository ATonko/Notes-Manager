package com.example.notesmanager.utils

import com.example.notesmanager.ui.model.NoteItem

internal object MockData {

    private val mockNoteList = mutableListOf(
        NoteItem("id 1", "Note 1", "Note 1 Content"),
        NoteItem("id 2", "Note 2", "Note 2 Content"),
        NoteItem("id 3", "Note 3", "Note 3 Content"),
        NoteItem("id 4", "Note 4", "Note 4 Content"),
    )

    internal fun getMockNoteList(): List<NoteItem> = mockNoteList

    internal fun saveNote(noteToSave: NoteItem) {
        if (isNewNote(noteToSave)) {
            mockNoteList.add(noteToSave)
        }
        else {
            mockNoteList.replaceAll {
                if (it.id == noteToSave.id)
                    noteToSave
                else
                    it
            }
        }
    }

    private fun isNewNote(noteItem: NoteItem): Boolean =
            !mockNoteList.contains(noteItem)

    fun deleteNote(noteToDelete: NoteItem) {
        mockNoteList.remove(noteToDelete)
    }


}