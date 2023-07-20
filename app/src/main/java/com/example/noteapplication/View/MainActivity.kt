package com.example.noteapplication.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.noteapplication.NoteApplication
import com.example.noteapplication.R
import com.example.noteapplication.ViewModel.NoteViewModel
import com.example.noteapplication.ViewModel.NoteViewModelFactory

class MainActivity : AppCompatActivity() {

    lateinit var noteViewModel: NoteViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val modelViewFactory = NoteViewModelFactory((application as NoteApplication).repository)
        noteViewModel = ViewModelProvider(this, modelViewFactory).get(NoteViewModel::class.java)

        noteViewModel.myAllNotes.observe(this, {notes ->

        })
    }
}