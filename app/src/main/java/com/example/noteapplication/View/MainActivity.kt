package com.example.noteapplication.View

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.noteapplication.Adapters.NoteAdapter
import com.example.noteapplication.NoteApplication
import com.example.noteapplication.R
import com.example.noteapplication.ViewModel.NoteViewModel
import com.example.noteapplication.ViewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val noteAdapter = NoteAdapter()
        recyclerView.adapter = noteAdapter

        val modelViewFactory = NoteViewModelFactory((application as NoteApplication).repository)
        noteViewModel = ViewModelProvider(this, modelViewFactory).get(NoteViewModel::class.java)

        noteViewModel.myAllNotes.observe(
            this,
        ) { notes ->
            noteAdapter.setNote(notes)
        }
    }
}