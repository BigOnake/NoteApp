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
import com.example.noteapp.presentation.noteList.ViewModel

class NoteWindowFragment : Fragment() {

    private var savedWindowTitle: String = String()
    private var savedWindowDescription: String = String()
    private val noteModel = NoteModel(null)

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
        setNote()
        //saveNote()
    }

    private fun initView(v: View) {
        windowTitle = v.findViewById(R.id.window_title)
        windowDescription = v.findViewById(R.id.window_description)
        saveButton = v.findViewById(R.id.save_button)
    }

    private fun saveNote() {
        viewModel.addNote(noteModel)
        Log.d("ololo", "$savedWindowTitle | $savedWindowDescription")
    }

    private fun setNote() {
        windowTitle.setOnFocusChangeListener { _, b ->
            if (!b){
                savedWindowTitle = windowTitle.text.toString()
                windowTitle.setText(savedWindowTitle)
                Log.d("ololo", "${windowTitle.text} has been changed")
            }else{
                Log.d("ololo", "${windowTitle.text} is focused")
            }
        }

        windowDescription.setOnFocusChangeListener { _, b ->
            if (!b){
                savedWindowDescription = windowDescription.text.toString()
                windowDescription.setText(savedWindowDescription)
                Log.d("ololo", "${windowDescription.text} has been changed")
            }else{
                Log.d("ololo", "${windowDescription.text} is focused")
            }
        }

        Log.d("ololo", "$savedWindowTitle $savedWindowDescription")
    }
}
//  noteModel.noteTitle = windowTitle.text.toString()
//  noteModel.noteDescription = windowDescription.text.toString()