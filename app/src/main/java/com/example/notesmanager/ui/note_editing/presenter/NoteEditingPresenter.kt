package com.example.notesmanager.ui.note_editing.presenter

import com.example.notesmanager.business.note_editing.INoteEditingInteractor
import com.example.notesmanager.core.mvp.Presenter
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.ui.note_editing.view.INoteEditingView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

internal class NoteEditingPresenter @Inject constructor(
    private val interactor: INoteEditingInteractor
) : INoteEditingPresenter, Presenter<INoteEditingView>() {

    private var noteItem: NoteItem? = null

    override fun onViewReady(noteItem: NoteItem) {
        this.noteItem = noteItem
        setUI(noteItem)
    }

    private fun setUI(noteItem: NoteItem) {
        view?.setToolbar(noteItem.title)
        view?.setContent(noteItem.content)
    }

    override fun onMenuItemClick(noteContent: String) {
        noteItem?.content = noteContent
        compositeDisposable += interactor.saveNote(noteItem)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate { view?.clearEditNoteFieldFocus() }
            .subscribe({
                print("complete")
            }, ::handleError)
    }

    override fun onBackPressed(noteContentToSave:String) {
        view?.goToNoteList()
    }

    private fun handleError(throwable: Throwable) {
        print("NoteEditingPresenter error: $throwable")
    }
}