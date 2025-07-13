package com.example.sharedprefprac.model

data class NoteDataClass(
    val id: Long = System.currentTimeMillis(),
    val title: String,
    val description: String
)
