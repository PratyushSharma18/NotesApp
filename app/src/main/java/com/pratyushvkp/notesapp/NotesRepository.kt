package com.pratyushvkp.notesapp

import androidx.lifecycle.LiveData

class NotesRepository(private val notesDao: NotesDao) {

    val allNotes : LiveData<List<Notes>> = notesDao.getAllNotes()

    suspend fun insert(note: Notes){
        notesDao.insert(note)
    }

    suspend fun delete(note: Notes){
        notesDao.delete(note)
    }


}