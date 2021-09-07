package com.example.noteapp.presentation.noteList

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.noteapp.data.NoteDataBase
import com.example.noteapp.data.NoteRepository
import com.example.noteapp.model.NoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ViewModel(application: Application): AndroidViewModel(application) {

    private val repository: NoteRepository
    private var readAll: List<NoteModel>? = null

    init {
        val noteDataBase = NoteDataBase.getDataBase(application).noteDao()
        repository = NoteRepository(noteDataBase)

        viewModelScope.launch(Dispatchers.IO) {
            readAll = repository.getAllNotes()
        }
    }

    fun addNote(note: NoteModel){
       viewModelScope.launch(Dispatchers.IO) {
           repository.insertNotes(note)

           Log.i("ololo", "NoteList size: ${repository.getAllNotes().size}", )

           Log.i("ololo", "INSERTED notes ${readAll.toString()}")
       }
    }

    fun getAllNotes(){
        viewModelScope.launch(Dispatchers.IO){
            repository.getAllNotes()
            Log.w("ololo", "READ notes ${readAll.toString()}")
        }
    }

    fun deleteAllNotes(){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteAllNotes()
        }
    }


}