package com.example.noteapplication.View

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.noteapplication.R

class UpdateActivity : AppCompatActivity() {
    lateinit var editTextTile: EditText
    lateinit var editTextDescription: EditText
    lateinit var buttonCancel: Button
    lateinit var buttonSave: Button

    var currentNoteId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update)

        editTextTile = findViewById(R.id.editTextNoteTitle)
        editTextDescription = findViewById(R.id.editTextNoteDescription)
        buttonCancel = findViewById(R.id.buttonUpdateCancel)
        buttonSave = findViewById(R.id.buttonUpdateSave)

        getAndSetData()

        buttonCancel.setOnClickListener {
            Toast.makeText(this, "Nothing Updated", Toast.LENGTH_LONG).show()
            finish()
        }

        buttonSave.setOnClickListener {
            updateNote()
        }
    }

    fun updateNote() {
        val updatedTitle = editTextTile.text.toString()
        val updatedDescription = editTextDescription.text.toString()

        val intent: Intent = Intent()
        intent.putExtra("updatedTitle", updatedTitle)
        intent.putExtra("updatedDescription", updatedDescription)

        if(currentNoteId != -1) {
            intent.putExtra("noteId", currentNoteId)
            setResult(RESULT_OK, intent)
            finish()
        }
    }

    fun getAndSetData() {
        val currentTitle = intent.getStringExtra("currentTitle").toString()
        val currentDescription = intent.getStringExtra("currentDescription").toString()
        currentNoteId = intent.getIntExtra("currentId", -1)

        editTextTile.setText(currentTitle)
        editTextDescription.setText(currentDescription)
    }
}