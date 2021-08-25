package com.example.noteapp.presentation.noteList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.NoteDataBase
import com.example.noteapp.data.NoteRepository
import com.example.noteapp.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NoteRepository
    private var readAll: LiveData<List<NoteModel>>

    init {
        val noteDataBase = NoteDataBase.getDataBase(application).noteDao()
        repository = NoteRepository(noteDataBase)
        readAll = repository.getAllNotes()
    }

    fun addNote(note: NoteModel){
       viewModelScope.launch(Dispatchers.IO) {
           repository.insertNotes(note)
       }
    }
}