package com.example.sharedprefprac.view

import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.sharedprefprac.R
import com.example.sharedprefprac.databinding.ActivityMainBinding
import com.example.sharedprefprac.model.NoteDataClass
import com.example.sharedprefprac.viewmodel.NoteViewModel

class MainActivity : AppCompatActivity() {
    private val viewModel: NoteViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: NoteAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        adapter = NoteAdapter(
            mutableListOf(),
            onClick = {
                Toast.makeText(this, "${it.title} clicked", Toast.LENGTH_SHORT).show()
            },
            onLongClick = {
                AlertDialog.Builder(this)
                    .setTitle("Delete Note")
                    .setMessage("Are you sure you want to delete this or not?")
                    .setPositiveButton("Delete") { _, _ -> viewModel.deleteNotes(it) }
                    .setNegativeButton("Cancel", null)
                    .show()

            }
        )


        binding.RecyclerView.layoutManager = LinearLayoutManager(this)
        binding.RecyclerView.adapter = adapter
        viewModel.notes.observe(this, Observer {
            adapter.updateNotes(it)
        })

        binding.FloatingActionButton.setOnClickListener {
            showAddNoteDialog()
        }

    }

    private fun showAddNoteDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add Quote")

        val view = layoutInflater.inflate(R.layout.dialog_add_note, null)
        builder.setView(view)


        val titleEditText = view.findViewById<EditText>(R.id.ET1)
        val descriptionEditText = view.findViewById<EditText>(R.id.ET2)

        builder.setPositiveButton("Add") { _, _ ->
            val title = titleEditText.text.toString()
            val description = descriptionEditText.text.toString()
            if (title.isNotEmpty() && description.isNotEmpty()) {
                viewModel.addNotes(NoteDataClass(title = title, description = description))
            }

        }
        builder.setNegativeButton("Cancel", null)

        builder.show()
    }
}