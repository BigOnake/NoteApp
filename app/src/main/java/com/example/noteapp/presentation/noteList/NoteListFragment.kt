package com.example.noteapp.presentation.noteList

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapp.R
import com.example.noteapp.presentation.noteWindow.NoteWindowFragment
import com.google.android.material.floatingactionbutton.FloatingActionButton

class NoteListFragment : Fragment() {

    //private val noteModel = NoteModel(null)

    private lateinit var fab:FloatingActionButton
    private lateinit var noteWindowFragment: NoteWindowFragment
    private lateinit var viewModel: ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("ololo", "NoteListFragment " + lifecycle.currentState.toString())

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        initView(view)
        createRecyclerView(view)
        onClick()
    }

    private fun createRecyclerView(v: View) {
        val notesAdapter = NoteListAdapter()
        val recyclerView: RecyclerView = v.findViewById(R.id.recycler_view)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            recyclerView.adapter = notesAdapter
        }
        Log.d("ololo", "RecyclerView has been created")
    }

    private fun initView(v:View){
        fab = v.findViewById(R.id.fab)
    }

    private fun onClick(){
        fab.setOnClickListener{
            openNoteWindowFragment()
        }
    }

    private fun openNoteWindowFragment(){
        Toast.makeText(context, "FAB was clicked", Toast.LENGTH_SHORT).show()
        val activity: AppCompatActivity = context as AppCompatActivity
        noteWindowFragment = NoteWindowFragment()
        activity.supportFragmentManager.beginTransaction()
            .replace(R.id.main_fragment_container, noteWindowFragment)
            .addToBackStack(null).commit()

        Log.d("ololo", lifecycle.currentState.toString())
        Log.d("ololo", "NoteWindowFragment was opened | " + noteWindowFragment.lifecycle.currentState.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.e("ololo", lifecycle.currentState.toString())
    }

}