package com.pratyushvkp.notesapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class NotesRVadapter(private val context: Context , private val listner: INotesRVadapter) :RecyclerView.Adapter<NotesRVadapter.NotesViewHolder>() {

   private val allNotes = ArrayList<Notes>()
    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val textView: TextView = itemView.findViewById<TextView>(R.id.text)
        val deleteButton : ImageView= itemView.findViewById<ImageView>(R.id.deleteButton)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
      val viewHolder = NotesViewHolder(LayoutInflater.from(context).inflate(R.layout.item_notes, parent,false))
       viewHolder.deleteButton.setOnClickListener{
           listner.onItemClicked(allNotes[viewHolder.adapterPosition])
       }
        return viewHolder
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {
       val currentNote = allNotes[position]
        holder.textView.text = currentNote.text
    }

    override fun getItemCount(): Int {
        return allNotes.size
    }

    fun updateList(newList: List<Notes>){
        allNotes.clear()
        allNotes.addAll(newList)

        notifyDataSetChanged()
    }
}

interface INotesRVadapter {
    fun onItemClicked(note: Notes)

}