package com.example.notesmanager.ui.notes_list.presenter

import com.example.notesmanager.R
import com.example.notesmanager.business.note_list.INoteListInteractor
import com.example.notesmanager.core.mvp.Presenter
import com.example.notesmanager.core.utils.AndroidServices
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.ui.notes_list.view.INotesListView
import com.example.notesmanager.utils.Constants.EMPTY_STRING
import com.example.notesmanager.utils.Constants.ONE_MORE
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class NoteListPresenter @Inject constructor(
    private val interactor: INoteListInteractor,
    private val androidServices: AndroidServices
) : INotesListPresenter, Presenter<INotesListView>() {

    private var noteList: List<NoteItem>? = null

    override fun onViewReady() {
        setUi()
        compositeDisposable += interactor.getList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                noteList = it
                view?.setNoteList(it)
            }, {
                println(it)
            })
    }

    override fun onNoteItemClick(noteItem: NoteItem) {
        view?.goToNoteEditing(noteItem)
    }

    override fun onNoteItemLongClick(noteItem: NoteItem) {
        compositeDisposable += interactor.deleteNote(noteItem)
            .andThen(interactor.getList())
            .subscribe({
                view?.updateNoteList(it)
            }, {

            })
    }

    override fun onNewNoteClick() {
        val newNote = NoteItem(
            id = generateNewId(),
            title = androidServices.getString(R.string.new_note),
            content = EMPTY_STRING
        )

        view?.goToNoteEditing(newNote)
    }

    private fun generateNewId(): String =
            "${androidServices.getString(R.string.id)}${noteList?.size?.plus(ONE_MORE)}"


    private fun setUi() {
        view?.setToolbar(androidServices.getString(R.string.note_list_title))
    }

}
