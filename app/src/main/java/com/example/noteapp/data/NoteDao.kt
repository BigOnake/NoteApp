package com.example.noteapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.noteapp.model.NoteModel

@Dao
interface NoteDao {

    @Insert
    suspend fun insertNote(noteModel: NoteModel)

    @Update
    suspend fun updateNote(noteModel: NoteModel)

    @Query("SELECT * FROM note_data_table")
    fun getAllNotes(): List<NoteModel>

    @Delete
    suspend fun deleteNote(noteModel: NoteModel)
}