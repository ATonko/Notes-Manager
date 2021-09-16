package com.example.notesmanager.database.repositories.real_data

import com.example.notesmanager.business.mapper.IMapper
import com.example.notesmanager.database.INoteListRepository
import com.example.notesmanager.database.room.NoteDao
import com.example.notesmanager.database.room.NoteRoomEntity
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.utils.NoteToSaveNullError
import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class NoteListRepository @Inject constructor(
    private val noteDao: NoteDao,
    private val mapper: IMapper<NoteRoomEntity, NoteItem>
) : INoteListRepository {
    override fun getList(): Single<List<NoteItem>> =
            noteDao.getList()
                .flatMap {
                    Single.just(getNoteItemList(it))
                }

    private fun getNoteItemList(noteRoomEntityList: List<NoteRoomEntity>): List<NoteItem> {
        val noteItemList = mutableListOf<NoteItem>()
        for (entity in noteRoomEntityList) {
            val noteItem = mapper.mapFrom(entity)
            noteItem?.let {
                noteItemList.add(it)
            }
        }
        return noteItemList
    }

    override fun saveNote(noteItem: NoteItem): Completable {
        val noteRoomEntity = mapper.mapFrom(noteItem)
        return if (noteRoomEntity != null)
            noteDao.saveNote(noteRoomEntity)
        else
            Completable.error(NoteToSaveNullError())
    }

    override fun deleteNote(noteToDelete: NoteItem): Completable {
        val noteRoomEntity = mapper.mapFrom(noteToDelete)
        return if (noteRoomEntity != null)
            Completable.fromAction { noteDao.deleteNote(noteRoomEntity) }
        else
            Completable.error(NoteToSaveNullError())
    }

}