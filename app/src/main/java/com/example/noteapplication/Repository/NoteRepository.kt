package com.example.noteapplication.Repository

import androidx.annotation.WorkerThread
import com.example.noteapplication.Model.Note
import com.example.noteapplication.Room.NoteDOA
import kotlinx.coroutines.flow.Flow

class NoteRepository(private val noteDOA: NoteDOA) {
    val myAllNotes: Flow<List<Note>> = noteDOA.getAllNotes()

    @WorkerThread
    suspend fun insert(note: Note) {
        noteDOA.insert(note)
    }

    @WorkerThread
    suspend fun update(note: Note) {
        noteDOA.update(note)
    }

    @WorkerThread
    suspend fun delete(note: Note) {
        noteDOA.delete(note)
    }

    @WorkerThread
    suspend fun deleteAllNotes() {
        noteDOA.deleteAllNotes()
    }
}