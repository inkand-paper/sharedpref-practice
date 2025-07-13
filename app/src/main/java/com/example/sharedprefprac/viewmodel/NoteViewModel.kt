package com.example.sharedprefprac.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.sharedprefprac.model.NoteDataClass
import com.example.sharedprefprac.repository.NoteRepository

class NoteViewModel(application: Application): AndroidViewModel(application) {
    private val repository = NoteRepository(application)
    private val _notes = MutableLiveData<List<NoteDataClass>>()
    val notes: LiveData<List<NoteDataClass>> = _notes

    init {
        loadNotes()
    }

    private fun loadNotes() {
        _notes.value = repository.getNotes()
    }

    fun addNotes(note: NoteDataClass){
        val update = _notes.value.orEmpty().toMutableList()
        update.add(note)
        _notes.value = update
        repository.saveNotes(update)
    }
    fun deleteNotes(note: NoteDataClass){
        val update = _notes.value.orEmpty().toMutableList()
        update.remove(note)
        _notes.value = update
        repository.saveNotes(update)
    }
}