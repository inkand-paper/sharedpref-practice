package com.example.sharedprefprac.utils

import android.content.Context
import android.content.SharedPreferences
import com.example.sharedprefprac.model.NoteDataClass
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class SharedPrefHelper(context: Context) {
    private val sharedPref: SharedPreferences = context.getSharedPreferences("notes_pref",Context.MODE_PRIVATE)
    private val gson = Gson()

    fun saveNotes(notes: List<NoteDataClass>){
        val json = gson.toJson(notes)
        sharedPref.edit().putString("notes_list",json).apply()
    }
    fun getNotes(): List<NoteDataClass>{
        val json = sharedPref.getString("notes_list",null)
        return if (json != null){
            val type = object : TypeToken<List<NoteDataClass>>() {}.type
            gson.fromJson(json, type)
        } else {
            emptyList()
        }
    }
}