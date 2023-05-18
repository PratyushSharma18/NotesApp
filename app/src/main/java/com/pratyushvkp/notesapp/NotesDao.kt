package com.pratyushvkp.notesapp


import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface NotesDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
     fun insert(note : Notes)
    @Delete
     fun delete(note : Notes)
    @Query("Select * from notes_table order by id ASC")
    fun getAllNotes(): LiveData<List<Notes>>

}