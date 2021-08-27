package com.example.noteapp.presentation.noteList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.model.NoteModel
import com.example.noteapp.R

class NoteListAdapter : RecyclerView.Adapter<NoteListAdapter.NoteViewHolder>() {

    private var noteListArray = ArrayList<NoteModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.note_view_holder, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind(noteListArray[position])
    }

    override fun getItemCount(): Int {
        return noteListArray.size
    }

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private var noteListTitle: TextView = view.findViewById(R.id.note_list_title)
        private var noteListDescription: TextView = view.findViewById(R.id.note_list_description)

        fun onBind(noteModel: NoteModel) {
            noteListTitle.text = noteModel.noteTitle.toString()
            noteListDescription.text = noteModel.noteDescription.toString()
        }
    }
}