package com.example.noteapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NoteListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("ololo", lifecycle.currentState.toString())
        createRecyclerView(view)
    }

    private fun createRecyclerView(v: View) {
        val notesAdapter = NotesAdapter()
        val recyclerView: RecyclerView = v.findViewById(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = notesAdapter
        }
        Log.d("ololo", "RecyclerView has been created")
    }

}