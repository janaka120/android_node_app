package com.example.noteapplication.View

import android.content.Intent
import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.quicksettings.Tile
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.noteapplication.R

class NoteAddActivity : AppCompatActivity() {
    lateinit var editTextTile: EditText
    lateinit var editTextDescription: EditText
    lateinit var buttonCancel: Button
    lateinit var buttonSave: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_note_add)

        supportActionBar?.title = "Create New Note"

        editTextTile = findViewById(R.id.editTextTitle)
        editTextDescription = findViewById(R.id.editTextDescription)
        buttonCancel = findViewById(R.id.buttonCancel)
        buttonSave = findViewById(R.id.buttonSave)

        buttonCancel.setOnClickListener {
            Toast.makeText(this, "Nothing Saved", Toast.LENGTH_LONG).show()
            finish()
        }

        buttonSave.setOnClickListener {
            createNote()
        }
    }

    fun createNote() {
        val noteTitle: String = editTextTile.text.toString()
        val noteDescription: String = editTextDescription.text.toString()

        val intent = Intent()
        intent.putExtra("title", noteTitle)
        intent.putExtra("description", noteDescription)
        setResult(RESULT_OK, intent)
        finish()
    }
}