package com.example.noteapp.model

data class NoteModel(
    val noteId: Int,
    var noteTitle: String = "Note title empty",
    var noteMainText: String = "Note text is empty"
)