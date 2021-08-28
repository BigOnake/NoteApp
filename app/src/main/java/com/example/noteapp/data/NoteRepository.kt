package com.example.noteapp.data

import com.example.noteapp.model.NoteModel

class NoteRepository(private val noteDao: NoteDao) {

    suspend fun insertNotes(noteModel: NoteModel) =
        noteDao.insertNote(noteModel)

    suspend fun updateNotes(noteModel: NoteModel) =
        noteDao.updateNote(noteModel)

    suspend fun deleteNotes(noteModel: NoteModel) =
        noteDao.deleteNote(noteModel)

    fun deleteAllNotes() =
        noteDao.deleteAllNotes()

    fun getAllNotes(): List<NoteModel> = noteDao.getAllNotes()
}