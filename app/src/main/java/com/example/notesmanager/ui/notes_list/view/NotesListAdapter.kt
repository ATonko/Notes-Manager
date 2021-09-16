package com.example.notesmanager.ui.notes_list.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.notesmanager.R
import com.example.notesmanager.ui.model.NoteItem
import kotlinx.android.synthetic.main.item_note.view.*

internal class NotesListAdapter(
    private val notesList: List<NoteItem>,
    private val onItemClickListener: (NoteItem) -> Unit,
    private val onItemLongClickListener: (NoteItem) -> Unit,
) :
    RecyclerView.Adapter<NotesListAdapter.NoteItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteItemViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_note, parent, false)
        return NoteItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteItemViewHolder, position: Int) {
        holder.bind(notesList[position])
    }

    override fun getItemCount(): Int = notesList.size

    inner class NoteItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(note: NoteItem) {
            itemView.tvNote.text = note.title
            itemView.setOnClickListener { onItemClickListener.invoke(note) }
            itemView.setOnLongClickListener {
                onItemLongClickListener.invoke(note)
                true
            }
        }
    }
}

