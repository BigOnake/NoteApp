package com.example.noteapp.presentation.noteWindow

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.example.noteapp.R

class NoteWindowFragment : Fragment() {

    private var savedWindowTitle: String = String()
    private var savedWindowDescription: String = String()
    private lateinit var windowTitle: EditText
    private lateinit var windowDescription: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_note_window, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
    }

    private fun initView(v: View) {
        windowTitle = v.findViewById(R.id.window_title)
        windowDescription = v.findViewById(R.id.window_description)
    }

    private fun editTextChange() {
        windowTitle.setOnFocusChangeListener { view, b ->
            if (!b) {
                saveNote()
            }
        }

        windowDescription.setOnFocusChangeListener { view, b ->
            if (!b) {
                saveNote()
            }
        }

        Log.d("ololo", "$savedWindowTitle | $savedWindowDescription")
    }

    private fun saveNote() {
        //Saves EditText var values in String var
        savedWindowTitle = windowTitle.text.toString()
        savedWindowDescription = windowDescription.text.toString()
        Log.d("ololo", "$savedWindowTitle $savedWindowDescription")
    }

    override fun onResume() {
        super.onResume()
        editTextChange()
    }
}