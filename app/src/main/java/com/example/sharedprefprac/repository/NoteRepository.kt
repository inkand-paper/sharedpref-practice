package com.example.sharedprefprac.repository

import android.content.Context
import com.example.sharedprefprac.model.NoteDataClass
import com.example.sharedprefprac.utils.SharedPrefHelper

class NoteRepository(context: Context) {
    private val prefHelper = SharedPrefHelper(context)

    fun saveNotes(notes: List<NoteDataClass>){
        return prefHelper.saveNotes(notes)
    }


    fun getNotes():List<NoteDataClass>{
        return prefHelper.getNotes()
    }
}