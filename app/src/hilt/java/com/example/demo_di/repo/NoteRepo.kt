package com.example.demo_di.repo

import com.example.demo_di.model.Note
import com.example.demo_di.storage.NoteDao
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NoteRepo @Inject constructor(val noteDao: NoteDao) {
    suspend fun getAllNote(): List<Note> {
        return noteDao.getAllNote()
    }

    suspend fun insertANote(note: Note) {
        noteDao.insertANote(note)
    }
    suspend fun insertNotes(note: List<Note>) {
        noteDao.insertNotes(note)
    }

}