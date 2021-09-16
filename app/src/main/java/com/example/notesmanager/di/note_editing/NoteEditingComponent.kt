package com.example.notesmanager.di.note_editing

import com.example.notesmanager.business.note_editing.INoteEditingInteractor
import com.example.notesmanager.business.note_editing.NoteEditingInteractor
import com.example.notesmanager.ui.note_editing.presenter.INoteEditingPresenter
import com.example.notesmanager.ui.note_editing.presenter.NoteEditingPresenter
import com.example.notesmanager.ui.note_editing.view.NoteEditingFragment
import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Scope


@Subcomponent(modules = [NoteEditingModule::class])
@NoteEditingScope
internal interface NoteEditingComponent {
    fun inject(fragment: NoteEditingFragment)
}

@Module
internal interface NoteEditingModule {

    @Binds
    @NoteEditingScope
    fun bindPresenter(impl: NoteEditingPresenter): INoteEditingPresenter

    @Binds
    @NoteEditingScope
    fun bindInteractor(impl: NoteEditingInteractor): INoteEditingInteractor
}

@Scope
@Retention(AnnotationRetention.RUNTIME)
internal annotation class NoteEditingScope