package com.pratyushvkp.notesapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.room.Dao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val allNotes : LiveData<List<Notes>>
   private val repository : NotesRepository

    init {
        val Dao = Notedatabase.getDatabase(application).getNoteDao()
         repository = NotesRepository(Dao)
        allNotes = repository.allNotes
    }

    fun deleteNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.delete(note)
    }

    fun insertNote(note: Notes) = viewModelScope.launch(Dispatchers.IO) {
        repository.insert(note)
    }

}