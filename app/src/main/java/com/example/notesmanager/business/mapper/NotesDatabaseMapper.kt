package com.example.notesmanager.business.mapper

import com.example.notesmanager.database.room.NoteRoomEntity
import com.example.notesmanager.ui.model.NoteItem
import javax.inject.Inject

internal class NotesDatabaseMapper @Inject constructor() : IMapper<NoteRoomEntity, NoteItem> {
    override fun mapFrom(from: NoteRoomEntity?): NoteItem? {
        var noteItem: NoteItem? = null
        from?.let {
            noteItem = NoteItem(
                from.id,
                from.title,
                from.content
            )
        }

        return noteItem
    }

    override fun mapFrom(from: NoteItem?): NoteRoomEntity? {
        var noteRoomEntity: NoteRoomEntity? = null
        from?.let {
            noteRoomEntity = NoteRoomEntity(
                from.id,
                from.title,
                from.content
            )
        }

        return noteRoomEntity
    }
}