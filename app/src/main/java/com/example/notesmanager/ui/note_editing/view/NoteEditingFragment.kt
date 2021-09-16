package com.example.notesmanager.ui.note_editing.view

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.notesmanager.R
import com.example.notesmanager.core.utils.getToolbar
import com.example.notesmanager.core.utils.hideKeyboard
import com.example.notesmanager.core.utils.replaceFragment
import com.example.notesmanager.core.utils.withArguments
import com.example.notesmanager.di.ComponentManager
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.ui.note_editing.presenter.INoteEditingPresenter
import com.example.notesmanager.ui.notes_list.view.NotesListFragment
import com.example.notesmanager.utils.OnBackPressed
import kotlinx.android.synthetic.main.fragment_note_editing.*
import javax.inject.Inject

internal class NoteEditingFragment : Fragment(R.layout.fragment_note_editing), INoteEditingView, OnBackPressed {

    @Inject
    lateinit var presenter: INoteEditingPresenter

    init {
        ComponentManager.plusNoteEditingFragment().inject(this)
    }

    companion object {
        private const val ARG_NOTE_ITEM = "arg_note_item"

        fun newInstance(noteItem: NoteItem): NoteEditingFragment =
                NoteEditingFragment().withArguments {
                    putParcelable(ARG_NOTE_ITEM, noteItem)
                }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.bindView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val noteItem = arguments?.getParcelable<NoteItem>(ARG_NOTE_ITEM)

        noteItem?.let { presenter.onViewReady(it) }
    }

    override fun setToolbar(title: String) {
        getToolbar().apply {
            setTitle(title)
            inflateMenu(R.menu.menu_note_editing)
            menu.findItem(R.id.menu_note_save).setOnMenuItemClickListener {
                presenter.onMenuItemClick(etNoteEdit.text.toString())
                true
            }
        }
    }


    override fun setContent(content: String) {
        etNoteEdit.setText(content)
    }

    override fun clearEditNoteFieldFocus() {
        etNoteEdit.clearFocus()
        hideKeyboard(context, requireView())
    }

    override fun goToNoteList() {
        activity?.replaceFragment(NotesListFragment.newInstance())
    }

    override fun onBackPressed() {
        presenter.onBackPressed(etNoteEdit.text.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
        presenter.onDestroy()
        ComponentManager.clearNoteEditingComponent()
    }

}