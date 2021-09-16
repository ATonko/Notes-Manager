package com.example.notesmanager.di.note_list

import com.example.notesmanager.business.note_list.INoteListInteractor
import com.example.notesmanager.business.note_list.NoteListInteractor
import com.example.notesmanager.ui.notes_list.presenter.INotesListPresenter
import com.example.notesmanager.ui.notes_list.presenter.NoteListPresenter
import com.example.notesmanager.ui.notes_list.view.NotesListFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope

@Subcomponent(modules = [NoteListModule::class])
@NoteListScope
internal interface NoteListComponent {
    fun inject(fragment: NotesListFragment)
}

@Module
internal interface NoteListModule {

    @Binds
    @NoteListScope
    fun bindPresenter(impl: NoteListPresenter): INotesListPresenter

    @Binds
    @NoteListScope
    fun bindInteractor(impl: NoteListInteractor): INoteListInteractor
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class NoteListScope