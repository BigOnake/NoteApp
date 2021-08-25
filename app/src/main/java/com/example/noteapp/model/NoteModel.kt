package com.example.noteapp.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note_data_table")
data class NoteModel(
    @PrimaryKey(autoGenerate = true)
    val noteId: Int?,
    @ColumnInfo(name = "note_title")
    var noteTitle: String = "Note title empty",
    @ColumnInfo(name = "note_description")
    var noteDescription: String = "Note text is empty"
)