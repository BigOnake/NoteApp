package com.example.noteapp.presentation.noteWindow

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
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

    private fun initView(v: View) {
        windowTitle = v.findViewById(R.id.window_title)
        windowDescription = v.findViewById(R.id.window_description)
        saveButton = v.findViewById(R.id.save_button)
    }

    private fun setNoteText(note: NoteModel) {
        windowTitle.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //setTitle(note)
            }

            override fun afterTextChanged(p0: Editable?) {
                setTitle(note)
            }
        })

        windowDescription.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                //setDescription(note)
            }

            override fun afterTextChanged(p0: Editable?) {
                setDescription(note)
            }
        })
    }

    private fun setTitle(note: NoteModel) {
        savedWindowTitle = windowTitle.text.toString() // Saving View changes into mVariable
        note.noteTitle = savedWindowTitle //Setting mVariable to Model
        Log.v("ololo", "Title = ${noteModel.noteTitle}")
    }

    private fun setDescription(note: NoteModel) {
        savedWindowDescription =
            windowDescription.text.toString() // Saving View changes into mVariable
        note.noteDescription = savedWindowDescription //Setting mVariable to Model
        Log.v("ololo", "Desc = ${noteModel.noteDescription}")
    }

    private fun saveData(note: NoteModel) {
        viewModel.addNote(note)
        Log.e("ololo", "SaveData function ${viewModel.getAllNotes()}")
    }

    override fun onStop() {
        super.onStop()
        Log.i(
            "ololo", "NoteWindowList was opened | " + noteListFragment
                .lifecycle.currentState
                .toString()
        )
        saveData(noteModel)
        Log.w("ololo", "onStop function ${viewModel.getAllNotes()}")
    }
}