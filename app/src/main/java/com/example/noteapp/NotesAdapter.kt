package com.example.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class NotesAdapter : RecyclerView.Adapter<NotesAdapter.NoteViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.note_view_holder, parent, false)
        return NoteViewHolder(view)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        holder.onBind()
    }

    override fun getItemCount(): Int {
        return 1
    }

    inner class NoteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun onBind() {

        }
    }
}