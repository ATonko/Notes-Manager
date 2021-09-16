package com.example.notesmanager.ui.notes_list.view

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notesmanager.R
import com.example.notesmanager.core.utils.addFragment
import com.example.notesmanager.core.utils.getToolbar
import com.example.notesmanager.di.ComponentManager
import com.example.notesmanager.ui.model.NoteItem
import com.example.notesmanager.ui.note_editing.view.NoteEditingFragment
import com.example.notesmanager.ui.notes_list.presenter.INotesListPresenter
import kotlinx.android.synthetic.main.fragment_notes_list.*
import javax.inject.Inject

internal class NotesListFragment : Fragment(R.layout.fragment_notes_list), INotesListView {

    @Inject
    lateinit var presenter: INotesListPresenter

    init {
        ComponentManager.plusNoteListComponent().inject(this)
    }

    companion object {
        fun newInstance(): NotesListFragment = NotesListFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        presenter.bindView(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setupView()
        presenter.onViewReady()
    }

    private fun setupView() {
        fabNewNote.setImageDrawable(ContextCompat.getDrawable(this.requireContext(),R.drawable.ic_add_new_note))
    }

    private fun setListeners() {
        fabNewNote.setOnClickListener {
            presenter.onNewNoteClick()
        }
    }

    override fun setToolbar(title: String) {
        getToolbar().apply {
            setTitle(title)
        }
    }

    override fun updateNoteList(list: List<NoteItem>) {

    }

    override fun setNoteList(notes: List<NoteItem>) {
        rvNotesList.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        rvNotesList.adapter = NotesListAdapter(notes, presenter::onNoteItemClick, presenter::onNoteItemLongClick)
    }

    override fun goToNoteEditing(noteItem: NoteItem) {
        activity?.addFragment(NoteEditingFragment.newInstance(noteItem))
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unbindView()
        presenter.onDestroy()
        ComponentManager.clearNoteListComponent()
    }
}