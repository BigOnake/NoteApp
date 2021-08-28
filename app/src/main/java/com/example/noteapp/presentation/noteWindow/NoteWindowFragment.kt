package com.example.noteapp.presentation.noteWindow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.lifecycle.ViewModelProvider
import com.example.noteapp.R
import com.example.noteapp.model.NoteModel
import com.example.noteapp.presentation.noteList.NoteListFragment
import com.example.noteapp.presentation.noteList.ViewModel

class NoteWindowFragment : Fragment() {

    private var savedWindowTitle: String = String()
    private var savedWindowDescription: String = String()
    private val noteListFragment: NoteListFragment = NoteListFragment()
    private val noteModel: NoteModel = NoteModel()

    private lateinit var viewModel: ViewModel
    private lateinit var windowTitle: EditText
    private lateinit var windowDescription: EditText
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_window, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(ViewModel::class.java)
        initView(view)
        setNoteText(noteModel)
    }

    override fun onStop() {
        super.onStop()
        Log.e("ololo", lifecycle.currentState.toString())
        Log.d("ololo", "NoteWindowList was opened | " + noteListFragment.lifecycle.currentState.toString())
        saveData(noteModel)
    }

    private fun initView(v: View) {
        windowTitle = v.findViewById(R.id.window_title)
        windowDescription = v.findViewById(R.id.window_description)
        saveButton = v.findViewById(R.id.save_button)
    }

    private fun saveData(note: NoteModel) {
        viewModel.addNote(note)
        Log.d("ololo", viewModel.getAllNotes().toString())
    }

    private fun setNoteText(note :NoteModel) {
        windowTitle.setOnFocusChangeListener { _, b -> //Looking when View focus is changed
            if (!b) {
                savedWindowTitle = windowTitle.text.toString() // Saving View changes into mVariable
                note.noteTitle = savedWindowTitle //Setting mVariable to Model
                Log.d("ololo", "${windowTitle.text} has been changed")
                Log.e("ololo", "${noteModel.noteTitle} | ${noteModel.noteDescription}")
            } else {
                Log.d("ololo", "${windowTitle.text} is focused")
            }
        }

        windowDescription.setOnFocusChangeListener { _, b ->
            if (!b) {
                savedWindowDescription = windowDescription.text.toString() // Saving View changes into mVariable
                note.noteDescription = savedWindowDescription //Setting mVariable to Model
                Log.d("ololo", "${windowDescription.text} has been changed")
                Log.e("ololo", "${noteModel.noteTitle} | ${noteModel.noteDescription}")
            } else {
                Log.d("ololo", "${windowDescription.text} is focused")
            }
        }

    }
}