package com.pratyushvkp.notesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class MainActivity : AppCompatActivity(), INotesRVadapter {
    lateinit var viewModel: NotesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
         val adapter = NotesRVadapter(this,this)
        recyclerView.adapter = adapter

        viewModel = ViewModelProvider(this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NotesViewModel::class.java)

        viewModel.allNotes.observe(this, Observer {list->
            list?.let {
                adapter.updateList(it)
            }

        })


    }

    override fun onItemClicked(note: Notes) {
    viewModel.deleteNote(note)
        Toast.makeText(this,"${note.text}Deleted",Toast.LENGTH_LONG).show()
    }

    fun submitData(view: View) {
        val input : EditText = findViewById(R.id.input)
        val noteText = input.text.toString()
        if(noteText.isNotEmpty()){
            viewModel.insertNote(Notes(noteText))
            Toast.makeText(this,"$noteText Inserted",Toast.LENGTH_LONG).show()
        }
    }

}