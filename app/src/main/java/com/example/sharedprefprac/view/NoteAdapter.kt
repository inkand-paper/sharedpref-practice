package com.example.sharedprefprac.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.sharedprefprac.databinding.NoteItemBinding
import com.example.sharedprefprac.model.NoteDataClass

class NoteAdapter(
    private val noteList: MutableList<NoteDataClass>,
    private val onClick: (NoteDataClass) -> Unit,
    private val onLongClick: (NoteDataClass) -> Unit
):RecyclerView.Adapter<NoteAdapter.NoteViewHolder>() {
    class NoteViewHolder(val binding: NoteItemBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = NoteItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return NoteViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return noteList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = noteList[position]
        holder.binding.apply {
            holder.binding.TitleTV.text = note.title
            holder.binding.DescriptionTV.text = note.description
            holder.itemView.setOnClickListener { onClick(note) }
            holder.itemView.setOnLongClickListener {
                onLongClick(note)
                true
            }
        }
    }
    fun updateNotes(newNotes: List<NoteDataClass>){
        noteList.clear()
        noteList.addAll(newNotes)
        notifyDataSetChanged()
    }
}