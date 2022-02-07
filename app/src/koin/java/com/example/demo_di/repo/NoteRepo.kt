package com.example.demo_di.repo

import com.example.demo_di.model.Note
import com.example.demo_di.storage.NoteDao

class NoteRepo(val noteDao: NoteDao) {
    suspend fun getAllNote() = noteDao.getAllNote()
    suspend fun insertNotes(noteList: List<Note>) = noteDao.insertNotes(noteList)
}